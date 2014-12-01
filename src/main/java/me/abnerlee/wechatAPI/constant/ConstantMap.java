package me.abnerlee.wechatAPI.constant;

import me.abnerlee.utils.reader.PropertyReader;

import java.util.Map;

/**
 * Created by AbnerLee on 14-12-1.
 */
public class ConstantMap {
    public final static Map<String, String> ConstantMap = PropertyReader.readProperties("wechat.properties");
}
