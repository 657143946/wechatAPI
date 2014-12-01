package me.abnerlee.wechatAPI.constant;

import me.abnerlee.utils.reader.PropertyReader;

import java.util.Map;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 所有常量信息，从wechat.properties中读取
 */
public class ConstantMap {
    public final static Map<String, String> CONSTANT_MAP = PropertyReader.readProperties("wechat.properties");
}
