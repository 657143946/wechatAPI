package me.abnerlee.wechatAPI.api;

import me.abnerlee.utils.wechat.WechatTool;
import me.abnerlee.wechatAPI.constant.AccountConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by AbnerLee on 14-11-22.
 */


/**
 * 微信接口接入
 *
 * 微信文档中成为开发者的那个接口
 */
public class Accessor {

    /**
     * @param request 公众平台成为开发者接口，接收微信的验证请求，验证微信传来的信息
     * @return boolean 是否是微信开发者接口的信息
     */
    public static boolean checkSignature(HttpServletRequest request){
        return WechatTool.checkSignature(
                request.getParameter("signature"),
                request.getParameter("timestamp"),
                request.getParameter("nonce"),
                AccountConstant.TOKEN
        );
    }

    /**
     *
     * @param signature 标识符
     * @param timestamp 时间戳
     * @param nonce 随见数
     * @return boolean signature验证成功与否
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce){
        return WechatTool.checkSignature(signature, timestamp, nonce, AccountConstant.TOKEN);
    }

}
