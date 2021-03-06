package me.abnerlee.constant;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 公众平台接口的链接地址
 * 都带有默认的地址
 */
public class UrlConstant {
    /**
     * 申请平台access_token接口的地址
     */
    public final static String ACCESS_TOKEN_URL =
            ConstantMap.CONSTANT_MAP.get("access_token_url") == null?
                    "https://api.weixin.qq.com/cgi-bin/token":
                    ConstantMap.CONSTANT_MAP.get("access_token_url");
    /**
     * 查询微信平台服务器的ip地址接口的地址
     */
    public final static String IP_LIST_URL =
            ConstantMap.CONSTANT_MAP.get("ip_list_url") == null?
                    "https://api.weixin.qq.com/cgi-bin/getcallbackip":
                    ConstantMap.CONSTANT_MAP.get("ip_list_url");
    /**
     * 上传media到微信服务器接口的地址
     */
    public final static String MEDIA_UPLOAD_URL =
            ConstantMap.CONSTANT_MAP.get("media_upload_url") == null?
                    "http://file.api.weixin.qq.com/cgi-bin/media/upload":
                    ConstantMap.CONSTANT_MAP.get("media_upload_url");

    /**
     * 下载media的链接地址
     */
    public final static String MEDIA_DOWN_URL =
            ConstantMap.CONSTANT_MAP.get("media_down_url") == null?
                    "http://file.api.weixin.qq.com/cgi-bin/media/get":
                    ConstantMap.CONSTANT_MAP.get("media_down_url");


    /**
     * 获取关注者列表
     */
    public final static String USER_LIST_URL =
            ConstantMap.CONSTANT_MAP.get("user_list_url") == null?
                    "https://api.weixin.qq.com/cgi-bin/user/get":
                    ConstantMap.CONSTANT_MAP.get("user_list_url");

    /**
     * 群发接口，上传news信息的接口url
     */
    public final static String UPLOAD_NEWS_URL =
            ConstantMap.CONSTANT_MAP.get("upload_news_url") == null?
                    "https://api.weixin.qq.com/cgi-bin/media/uploadnews":
                    ConstantMap.CONSTANT_MAP.get("upload_news_url");
    /**
     * 群发接口地址
     */
    public final static String BROADCAST_MSG_URL =
            ConstantMap.CONSTANT_MAP.get("broadcast_msg_url") == null?
                    "https://api.weixin.qq.com/cgi-bin/message/mass/send":
                    ConstantMap.CONSTANT_MAP.get("broadcast_msg_url");

    /**
     * 群发接口中申请调用视屏的URL
     */
    public final static String QUERY_MEDIA_ID_URL =
            ConstantMap.CONSTANT_MAP.get("query_media_id_url") == null?
                    "https://file.api.weixin.qq.com/cgi-bin/media/uploadvideo":
                    ConstantMap.CONSTANT_MAP.get("query_media_id_url");



}
