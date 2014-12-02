package me.abnerlee.wechatAPI.constant;

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

}
