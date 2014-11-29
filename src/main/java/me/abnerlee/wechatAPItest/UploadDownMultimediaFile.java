package me.abnerlee.wechatAPItest;

import me.abnerlee.utils.client.HttpClientUtils;
import me.abnerlee.utils.json.JsonConvert;

import java.io.File;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 14-11-26.
 */
public class UploadDownMultimediaFile {
    public static Map<String, String> upload(String accessToken, String type, File file) {
        /** GET参数 **/
        Map<String, String> getParams = new HashMap<String, String>();
        /** access_token **/
        getParams.put("ACCESS_TOKEN", accessToken);
        /** type **/
        getParams.put("TYPE", type);
        String body = HttpClientUtils.request(Constant.MEDIA_UPLOAD_URL, getParams, null, file);
        return JsonConvert.jsonToMap(body);
    }

    public static Map<String, String> upload(File file) {
        String accessToken = AccessTokenRequest.getAccessToken();
        String type = judgeMediaType(file);
        return upload(accessToken, type, file);
    }

    public static Map<String, String> upload(String absoluteFilePath) {
        return upload(new File(absoluteFilePath));
    }

    public static String judgeMediaType(File file) {
        String type = "image";
        if (file != null) {
            String[] temp = file.getName().split(".");
            String extName = temp[temp.length-1].toLowerCase();
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

    public static String down(String accessToken, String mediaId){
        String downMediaUrlTemplate = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}";
        String url = MessageFormat.format(downMediaUrlTemplate, accessToken, mediaId);
        return url;
    }

    public static String down(String mediaId){
        String accessToken = AccessTokenRequest.getAccessToken();
        return down(accessToken, mediaId);
    }



    public static void main(String[] args) {
//        Map<String, String> body = upload("C:\\Users\\Administrator\\Desktop\\123.jpg");
//        System.out.println(body);
        String body = "{media_id=H6edkrLruxra8Mk_Y8o0oPjierSh8F9PuShta4vJ1ZTl1P_8s2zgPvMu8wuLfSX4, created_at=1416988988, type=image}";

        String mediaId = "H6edkrLruxra8Mk_Y8o0oPjierSh8F9PuShta4vJ1ZTl1P_8s2zgPvMu8wuLfSX4";
        String accessToken = AccessTokenRequest.getAccessToken();
        String downMediaUrlTemplate = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token={0}&media_id={1}";
        String url = MessageFormat.format(downMediaUrlTemplate, accessToken, mediaId);
        System.out.println(url);

    }
}
