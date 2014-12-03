package me.abnerlee.wechatAPI.api;

import me.abnerlee.constant.UrlConstant;
import me.abnerlee.util.client.HttpClientUtils;
import me.abnerlee.util.json.JsonConvert;

import java.io.File;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbnerLee on 14-11-26.
 */

/**
 * 上传下载媒体文件接口
 */
public class UploadDownMultimediaFile {

    /**
     * 上传媒体文件
     *
     * @param accessToken 本次上传文件允许的accessToken标识
     * @param type        上传文件的类型
     * @param file        File实例
     * @return json转化成map的map
     */
    public static Map<String, String> upload(String accessToken, String type, File file) {
        /** GET参数 **/
        Map<String, String> getParams = new HashMap<String, String>();
        /** access_token **/
        getParams.put("ACCESS_TOKEN", accessToken);
        /** type **/
        getParams.put("TYPE", type);
        String body = HttpClientUtils.postFile(UrlConstant.MEDIA_UPLOAD_URL, getParams, null, file);
        return JsonConvert.jsonToMap(body);
    }

    /**
     * 上传媒体文件
     *
     * @param file File实例
     * @return json转化成map的map
     */
    public static Map<String, String> upload(File file) {
        String accessToken = AccessTokenRequest.getAccessToken();
        String type = judgeMediaType(file);
        return upload(accessToken, type, file);
    }

    /**
     * 上传媒体文件
     *
     * @param absoluteFilePath 文件绝对路径
     * @return json转化成map的map
     */
    public static Map<String, String> upload(String absoluteFilePath) {
        return upload(new File(absoluteFilePath));
    }

    /**
     * 上传媒体文件
     *
     * @param file File实例
     * @return 媒体文件类型，String
     */
    public static String judgeMediaType(File file) {
        String type = "image";
        if (file != null) {
            String[] temp = file.getName().split(".");
            String extName = temp[temp.length - 1].toLowerCase();
            String image = "bmp;jpg;jpeg;png";
            String voice = "cda;wav;mp3;wma;midi;aiff;aif;au;snd;voc;ram;ra;rm";
            String video = "avi;flv;mpeg;mpg;";
            if (image.contains(file.getName())) {
                type = "image";
            } else if (voice.contains(file.getName())) {
                type = "voice";
            } else if (video.contains(file.getName())) {
                type = "video";
            } else {
                type = "image";
            }

        }
        return type;
    }

    /**
     * 下载媒体文件
     *
     * @param accessToken
     * @param mediaId
     * @return String 下载链接
     */
    public static String down(String accessToken, String mediaId) {
        String downMediaUrlTemplate = UrlConstant.MEDIA_DOWN_URL + "?access_token={0}&media_id={1}";
        String url = MessageFormat.format(downMediaUrlTemplate, accessToken, mediaId);
        return url;
    }

    /**
     * 下载媒体文件
     *
     * @param mediaId
     * @return String 下载链接
     */
    public static String down(String mediaId) {
        String accessToken = AccessTokenRequest.getAccessToken();
        return down(accessToken, mediaId);
    }

}
