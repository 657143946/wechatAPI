package me.abnerlee.wechatAPItest;

import me.abnerlee.utils.wechat.WechatTool;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 14-11-22.
 */
public class Accessor {
    public static boolean checkSignature(HttpServletRequest request){
        return WechatTool.checkSignature(
                request.getParameter("signature"),
                request.getParameter("timestamp"),
                request.getParameter("nonce"),
                Constant.TOKEN
        );
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce){
        return WechatTool.checkSignature(signature, timestamp, nonce, Constant.TOKEN);
    }

}
