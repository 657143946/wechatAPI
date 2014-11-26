package me.abnerlee.utils.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-10-10.
 */
public class HttpClientUtils {


    public static void  main(String[] args) throws Exception{
        String body = request("localhost/FingerHire/checkEmail",
                null,
                new HashMap<String, String>(){{
                    put("email", "657143946@qq.com");
                }});
        System.out.println(body);
    }

    public static String request(String url, Map<String, String> getData, Map<String, String> postData, File... files){
        HttpClient client=new HttpClient();
        /**整理URL**/
        if (!url.contains("http://") && !url.contains("https://")){
            url = "http://" + url;
        }

        /**加入get参数**/
        String getDataString = "";
        if (getData != null){
            for (String key: getData.keySet()){
                String value = getData.get(key);
                getDataString += key + "=" + value + "&";
            }
            getDataString = getDataString.substring(0, getDataString.length());
        }
        if (url.contains("?")){
            url += "&" + getDataString;
        }else {
            url += "?" + getDataString;
        }


        /**加入post参数**/
        PostMethod postMethod=new PostMethod(url);
        if (postData != null){
            for(String key: postData.keySet()){
                String value = postData.get(key);
                postMethod.addParameter(key, value);
            }
        }

        /**加入文件**/
        if (files != null && files.length != 0){
            Part[] parts = new Part[files.length];
            for (int i=0; i < files.length; i++){
                try {
                    parts[i] = new FilePart("file"+i, files[i]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            MultipartRequestEntity mre = new MultipartRequestEntity(parts, postMethod.getParams());
            postMethod.setRequestEntity(mre);
        }

        /**请求**/
        try{
            client.executeMethod(postMethod);
            String body = new String(postMethod.getResponseBody());
            postMethod.releaseConnection();
            return body;
        }catch (HttpException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
