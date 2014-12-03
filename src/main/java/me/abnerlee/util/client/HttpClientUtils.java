package me.abnerlee.util.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by AbnerLee on 14-10-10.
 * 发起请求的帮助类，里面封装了postFile，postJson
 */
public class HttpClientUtils {
    private static final Logger logger = LogManager.getLogger(HttpClientUtils.class.getName());

    /**
     * 为url检测并添加协议
     *
     * @param url
     * @param protocol 仅有http(默认)  https
     * @return 带有协议的url
     */
    private static String checkNetProtocol(String url, String protocol) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            if ("https".equals(protocol)) {
                url = "https://" + url;
            } else {
                url = "http://" + url;
            }
        }
        return url;
    }

    /**
     * 为url添加http协议头
     *
     * @param url
     * @return 带有协议的url
     */
    private static String checkNetProtocol(String url) {
        return checkNetProtocol(url, "http");
    }

    /**
     * 为url添加get参数
     *
     * @param url
     * @param getParams Map get参数键值对
     * @return 带有get参数的url
     */
    private static String addGetParams(String url, Map<String, String> getParams) {
        String getDataString = "";
        if (getParams != null) {
            for (String key : getParams.keySet()) {
                String value = getParams.get(key);
                getDataString += key + "=" + value + "&";
            }
            getDataString = getDataString.substring(0, getDataString.length());
        }
        if (url.contains("?")) {
            url += "&" + getDataString;
        } else {
            url += "?" + getDataString;
        }
        return url;
    }

    /**
     * 为postMethod添加post参数
     *
     * @param pm         PostMethod
     * @param postParams Map post参数键值对
     * @return 返回添加了post参数的
     */
    private static PostMethod addPostParams(PostMethod pm, Map<String, String> postParams) {
        if (postParams != null) {
            for (String key : postParams.keySet()) {
                String value = postParams.get(key);
                pm.addParameter(key, value);
            }
        }
        return pm;
    }

    /**
     * 构造上传文件要用的Part[]l
     *
     * @param files Map<String, File>  文件名以及对应文件的File  键值对
     * @return
     */
    private static Part[] constructFileParts(Map<String, File> files) {
        List<Part> parts = new LinkedList<Part>();
        if (files != null && files.size() != 0) {
            for (String name : files.keySet()) {
                File file = files.get(name);
                if (file != null) {
                    try {
                        parts.add(new FilePart(name, file));
                    } catch (FileNotFoundException e) {
                        logger.error("FileNotFoundException: " + file.getAbsolutePath());
                    }
                }
            }
        }
        return (Part[]) parts.toArray();
    }

    /**
     * 构造上传文件要用的Part[]
     *
     * @param files File
     * @return
     */
    private static Part[] constructFileParts(File... files) {
        Part[] parts = new Part[0];
        if (files != null) {
            Map<String, File> fileMap = new HashMap<String, File>();
            int index = 0;
            for (File file : files) {
                index++;
                fileMap.put("file_" + index, file);
            }
            parts = constructFileParts(fileMap);
        }
        return parts;
    }

    /**
     * 发起请求
     *
     * @param method HttpMethod
     * @return 请求返回后的body
     */
    private static String executeRequest(HttpMethod method) {
        HttpClient client = new HttpClient();
        try {
            client.executeMethod(method);
            String body = new String(method.getResponseBody());
            method.releaseConnection();
            return body;
        } catch (HttpException e) {
            logger.error("HttpException请求失败：" + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            logger.error("IOException请求失败：" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * post文件
     *
     * @param url        url
     * @param getParams  get参数
     * @param postParams post参数
     * @param files      Files[] 多个文件
     * @return 请求返回后的body
     */
    public static String postFile(String url, Map<String, String> getParams, Map<String, String> postParams, File... files) {
        /**检查or添加协议**/
        url = checkNetProtocol(url);
        /**加入get参数**/
        url = addGetParams(url, getParams);
        /**创建post方法**/
        PostMethod postMethod = new PostMethod(url);
        /**添加post参数**/
        postMethod = addPostParams(postMethod, postParams);
        /**构造文件Parts[]**/
        Part[] parts = constructFileParts(files);
        /**构造多媒体实体, 并且添加至post方法请求实体中**/
        MultipartRequestEntity mre = new MultipartRequestEntity(parts, postMethod.getParams());
        postMethod.setRequestEntity(mre);
        /**发起请求**/
        return executeRequest(postMethod);

    }

    private static RequestEntity constructJsonRequestEntity(String json) {
        StringRequestEntity requestEntity = null;
        if (json != null) {
            try {
                requestEntity = new StringRequestEntity(
                        json,
                        "application/json",
                        "UTF-8");
            } catch (UnsupportedEncodingException e) {
                logger.error("post Json错误: UnsupportedEncodingException");
                e.printStackTrace();
            }
        }
        return requestEntity;
    }

    /**
     * post json字符串
     *
     * @param url        url
     * @param getParams  get参数
     * @param postParams post参数
     * @param jsonStr    json字符串
     * @return String 请求返回后的body
     */
    public static String postJson(String url, Map<String, String> getParams, Map<String, String> postParams, String jsonStr) {
        /**检查or添加协议**/
        url = checkNetProtocol(url);
        /**加入get参数**/
        url = addGetParams(url, getParams);
        /**创建post方法**/
        PostMethod postMethod = new PostMethod(url);
        /**添加post参数**/
        postMethod = addPostParams(postMethod, postParams);

        /**加入json字符串**/
        RequestEntity requestEntity = constructJsonRequestEntity(jsonStr);
        postMethod.setRequestEntity(requestEntity);
        /**请求**/
        return executeRequest(postMethod);
    }
}
