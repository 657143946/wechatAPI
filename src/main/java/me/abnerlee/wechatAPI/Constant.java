package me.abnerlee.wechatAPI;

import me.abnerlee.utils.reader.PropertyReader;

import java.util.Map;

/**
 * Created by Administrator on 14-11-22.
 */
public class Constant {
    private static Map<String, String> constantMap = PropertyReader.readProperties("wechat.properties");
    public final static String TOKEN = constantMap.get("token");
    public final static String APPID = constantMap.get("appid");
    public final static String APPSECRET = constantMap.get("appsecret");
}
