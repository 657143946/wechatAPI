package me.abnerlee.wechatAPI.api;

import me.abnerlee.constant.XmlMsgTemplate;
import me.abnerlee.util.time.Timer;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 构造返回给用户的xml
 */
public class XmlConstructor {
    /**
     * 文本消息
     */
    public static String getTextXml(String to, String from, String content) {
        return MessageFormat.format(XmlMsgTemplate.TEXT_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis() / 1000, content);
    }

    /**
     * 图片消息
     */
    public static String getPictureXml(String to, String from, String mediaId) {
        return MessageFormat.format(XmlMsgTemplate.PICTURE_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis() / 1000, mediaId);
    }

    /**
     * 语音消息
     */
    public static String getVoiceXmlTemplate(String to, String from, String mediaId) {
        return MessageFormat.format(XmlMsgTemplate.VOICE_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis() / 1000, mediaId);
    }

    /**
     * 视频消息
     */
    public static String getVideoXml(String to, String from, String mediaId, String title, String desc) {
        return MessageFormat.format(XmlMsgTemplate.VOICE_XML_TEMPLATE, to, from,
                Timer.getCurrentTimestampMillis() / 1000, mediaId, title, desc);
    }

    /**
     * 音乐消息
     */
    public static String getMusicXml(String to, String from, String mediaId, String title, String desc) {
        return MessageFormat.format(XmlMsgTemplate.MUSIC_XML_TEMPLATE, to, from,
                Timer.getCurrentTimestampMillis() / 1000, mediaId, title, desc);
    }

    /**
     * 图文消息
     * 传入的items中，必须包含title, desc, pic, url
     */
    public static String getNewsXml(String to, String from, List<Map<String, String>> items) {
        int total = 0;
        String itemsStr = "";
        if (items != null) {
            for (Map<String, String> item : items) {
                itemsStr += MessageFormat.format(XmlMsgTemplate.ONE_NEW, item.get("title"), item.get("desc"), item.get("pic"), item.get("url"));
                total++;
            }
        }
        return MessageFormat.format(XmlMsgTemplate.NEWS_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis() / 1000, total, itemsStr);
    }
}
