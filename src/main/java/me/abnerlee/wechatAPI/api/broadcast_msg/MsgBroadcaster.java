package me.abnerlee.wechatAPI.api.broadcast_msg;

import me.abnerlee.constant.MsgtypeConstant;
import me.abnerlee.constant.UrlConstant;
import me.abnerlee.util.client.HttpClientUtils;
import me.abnerlee.util.json.JsonConvert;
import me.abnerlee.wechatAPI.api.AccessTokenRequest;
import me.abnerlee.wechatAPI.api.user_management.UserManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AbnerLee on 14-12-1.
 */


/**
 * 里面包含群发消息相关接口
 */
public class MsgBroadcaster {

    /**
     * 构造一条new，map形式返回
     *                        参数	                  是否必须	             说明
     * @param thumb_media_id     是	                图文消息缩略图的media_id，可以在基础支持-上传多媒体文件接口中获得
     * @param author             否	              图文消息的作者
     * @param title              是	              图文消息的标题
     * @param content_source_url 否	            在图文消息页面点击“阅读原文”后的页面
     * @param content            是	           图文消息页面的内容，支持HTML标签
     * @param digest             否	                 图文消息的描述
     * @param show_cover_pic     否	                  是否显示封面，1为显示，0为不显示
     * @return Map<String, String>
     */
    private static Map<String, String> construceOneNewMap(
            String thumb_media_id, String author, String title, String content_source_url,
            String content, String digest, String show_cover_pic) {
        Map<String, String> oneNew = new HashMap<String, String>();
        oneNew.put("thumb_media_id", thumb_media_id);
        oneNew.put("author", author);
        oneNew.put("title", title);
        oneNew.put("content_source_url", content_source_url);
        oneNew.put("content", content);
        oneNew.put("digest", digest);
        oneNew.put("show_cover_pic", show_cover_pic);
        return oneNew;
    }

    public static Map<String, String> uploadNewsMsg(String accessToken, String jsonStr) {
        /**
         * get参数
         */
        Map<String, String> getParams = new HashMap<String, String>();
        getParams.put("access_token", accessToken);

        return JsonConvert.jsonToMap(HttpClientUtils.postJson(UrlConstant.UPLOAD_NEWS_URL, getParams, null, jsonStr));

    }


    /**
     * 调用上传需要群发的news的，得到media_id，方便以后群发使用
     *
     * @param accessToken
     * @param news
     * @return
     */
    public static Map<String, String> uploadNewsMsg(String accessToken, List<Map<String, String>> news) {
        /**
         * 文本消息
         */
        Map<String, Object> articles = new HashMap<String, Object>();
        articles.put("articles", news);
        String json = JsonConvert.mapToJson(articles);

        /**
         * get参数
         */
        Map<String, String> getParams = new HashMap<String, String>();
        getParams.put("access_token", accessToken);

        return JsonConvert.jsonToMap(HttpClientUtils.postJson(UrlConstant.UPLOAD_NEWS_URL, getParams, null, json));
    }

    /**
     * 调用上传需要群发的news的，得到media_id，方便以后群发使用
     *
     * @param news
     * @return
     */
    public static Map<String, String> uploadNewsMsg(List<Map<String, String>> news) {
        return uploadNewsMsg(AccessTokenRequest.getAccessToken(), news);
    }

    /**
     * 群发video之前需要获取video允许，获取一个media_id
     */


    /**
     * @param accessToken
     * @param touser
     * @param media_id
     * @param msgtype
     * @return
     */
    public static Map<String, String> broadcastMsg(String accessToken, List<String> touser, String media_id, String msgtype) {
        /**
         * 构造json字符串
         */
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (MsgtypeConstant.VIDEO.equals(msgtype)) {

        } else {
            Map<String, String> media = new HashMap<String, String>();
            media.put("media_id", media_id);

            jsonMap.put("touser", touser);
            jsonMap.put("msgtype", msgtype);
            jsonMap.put(msgtype, media);

        }
        String json = JsonConvert.mapToJson(jsonMap);

        /**
         * get参数
         */
        Map<String, String> getParams = new HashMap<String, String>();
        getParams.put("access_token", accessToken);

        return JsonConvert.jsonToMap(HttpClientUtils.postJson(UrlConstant.BROADCAST_MSG_URL, getParams, null, json));

    }

    public static Map<String, String> broadcastMsg(List<String> touser, String media_id, String msgtype) {
        return broadcastMsg(AccessTokenRequest.getAccessToken(), touser, media_id, msgtype);
    }


    public static void main(String[] args) {
//        List<Map<String, String>> news = new LinkedList<Map<String, String>>();
//        news.add(construceOneNewMap(
//                "H6edkrLruxra8Mk_Y8o0oPjierSh8F9PuShta4vJ1ZTl1P_8s2zgPvMu8wuLfSX4",
//                "author",
//                "title",
//                "http://www.baidu.com",
//                "content",
//                "digest",
//                "1"
//                        ));
//        news.add(construceOneNewMap(
//                "H6edkrLruxra8Mk_Y8o0oPjierSh8F9PuShta4vJ1ZTl1P_8s2zgPvMu8wuLfSX4",
//                "author",
//                "title",
//                "http://www.baidu.com",
//                "content",
//                "digest",
//                "0"
//        ));
//
//
//        Map<String, String> result = uploadNewsMsg(news);
//        System.out.println(result);

        String a = "{media_id=tXfyv1NS_vdGsZzb3l_l-SWNMCtFWx2op_Y7pgA2uubioh6lIlmQEsavIj6TgV47, created_at=1417525271, type=news}";
        Map<String, String> result = broadcastMsg(
                UserManagement.getUserList(),
                "tXfyv1NS_vdGsZzb3l_l-SWNMCtFWx2op_Y7pgA2uubioh6lIlmQEsavIj6TgV47",
                "mpnews");
        System.out.println(result);
    }

}
