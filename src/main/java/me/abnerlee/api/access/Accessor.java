package me.abnerlee.api.access;

import me.abnerlee.constant.AccountConstant;
import me.abnerlee.constant.UrlConstant;
import me.abnerlee.entity.json.access.AccessTokenMsgEntity;
import me.abnerlee.util.client.HttpClientUtils;
import me.abnerlee.util.json.JsonConvert;
import me.abnerlee.util.wechat.WechatTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbnerLee on 14-11-22.
 */


/**
 * 微信接口接入的接口+获取access_token的接口
 */
public class Accessor {
    private static final Logger logger = LogManager.getLogger(Accessor.class.getName());

    /**
     * @param request 公众平台成为开发者接口，接收微信的验证请求，验证微信传来的信息
     * @return boolean 是否是微信开发者接口的信息
     */
    public static boolean checkSignature(HttpServletRequest request) {
        return WechatTool.checkSignature(
                request.getParameter("signature"),
                request.getParameter("timestamp"),
                request.getParameter("nonce"),
                AccountConstant.TOKEN
        );
    }

    /**
     * @param signature 标识符
     * @param timestamp 时间戳
     * @param nonce     随见数
     * @return boolean signature验证成功与否
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        return WechatTool.checkSignature(signature, timestamp, nonce, AccountConstant.TOKEN);
    }

    /**
     * 获取平台access_token
     *
     * @return access_token
     */
    public static String getAccessToken() {
        return getAccessToken(UrlConstant.ACCESS_TOKEN_URL);
    }

    /**
     * 获取平台access_token
     *
     * @return access_token
     */
    public static String getAccessToken(String url) {
        return getAccessToken(url, AccountConstant.APPID, AccountConstant.APPSECRET);
    }

    /**
     * 获取平台access_token
     *
     * @return access_token
     */
    public static String getAccessToken(String url, String appid, String secret) {
        return getAccessToken(url, "client_credential", appid, secret);
    }

    /**
     * 获取平台access_token
     *
     * @return access_token
     */
    public static String getAccessToken(String url, String grantType, String appid, String secret) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", grantType);
        params.put("appid", appid);
        params.put("secret", secret);

        AccessTokenMsgEntity entity = new AccessTokenMsgEntity();
        entity = JsonConvert.jsonToObject(
                HttpClientUtils.postParams(url, params, null),
                entity
                );
        if (entity.getErrmsg() != null) {
            logger.error("获取access_token失败：" + entity.getErrmsg());
            return null;
        } else {
            return entity.getAccess_token();
        }
    }
}
