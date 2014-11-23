package me.abnerlee.wechatAPI;

import me.abnerlee.utils.time.Timer;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-11-23.
 */
public class ConstructWechatXmlString {

    /**
     * 文本消息模板
     */
    public final static String TEXT_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[text]]></MsgType>\n" +
                "<Content><![CDATA[{3}]]></Content>\n" +
            "</xml>";

    /**
     * 图片消息模板
     */
    public final static String PICTURE_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[image]]></MsgType>\n" +
                "<Image>\n" +
                    "<MediaId><![CDATA[{3}]]></MediaId>\n" +
                "</Image>\n" +
            "</xml>";

    /**
     * 语音消息模板
     */
    public final static String VOICE_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[voice]]></MsgType>\n" +
                "<Voice>\n" +
                    "<MediaId><![CDATA[{3}]]></MediaId>\n" +
                "</Voice>\n" +
            "</xml>";

    /**
     * 视频消息模板
     */
    public final static String VIDEO_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[video]]></MsgType>\n" +
                "<Video>\n" +
                        "<MediaId><![CDATA[{3}]]></MediaId>\n" +
                        "<Title><![CDATA[{4}]]></Title>\n" +
                        "<Description><![CDATA[{5}]]></Description>\n" +
                "</Video>\n" +
            "</xml>";

    /**
     * 音乐消息模板
     */
    public final static String MUSIC_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[music]]></MsgType>\n" +
                "<Music>\n" +
                    "<MediaId><![CDATA[{3}]]></MediaId>\n" +
                    "<Title><![CDATA[{4}]]></Title>\n" +
                    "<Description><![CDATA[{5}]]></Description>\n" +
                "</Music>\n" +
             "</xml>";

    /**
     * 图文消息模板
     */
    public final static String NEWS_XML_TEMPLATE =
            "<xml>\n" +
                "<ToUserName><![CDATA[{0}]]></ToUserName>\n" +
                "<FromUserName><![CDATA[{1}]]></FromUserName>\n" +
                "<CreateTime>{2}</CreateTime>\n" +
                "<MsgType><![CDATA[news]]></MsgType>\n" +
                "<ArticleCount>{3}</ArticleCount>\n" +
                "<Articles>\n" +
                "{4}\n" +
                "</Articles>\n" +
            "</xml> ";
    public final static String ONE_NEW =
            "<item>\n" +
                "<Title><![CDATA[{0}]]></Title>\n" +
                "<Description><![CDATA[{1}]]></Description>\n" +
                "<PicUrl><![CDATA[{2}]]></PicUrl>\n" +
                "<Url><![CDATA[{3}]]></Url>\n" +
            "</item>\n";

    /**
     * 文本消息
     */
    public static String getTextXml(String to, String from, String content){
        return MessageFormat.format(TEXT_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis()/1000, content);
    }
    public static String getTextXml(String to, String content){
        return getTextXml(to, Constant.APPID, content);
    }

    /**
     * 图片消息
     */
    public static String getPictureXml(String to, String from, String mediaId){
        return MessageFormat.format(PICTURE_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis()/1000, mediaId);
    }
    public static String getPictureXml(String to, String mediaId){
        return getPictureXml(to, Constant.APPID, mediaId);
    }

    /**
     * 语音消息
     */
    public static String getVoiceXmlTemplate(String to, String from, String mediaId){
        return MessageFormat.format(VOICE_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis()/1000, mediaId);
    }
    public static String getVoiceXmlTemplate(String to, String mediaId){
        return getVoiceXmlTemplate(to, Constant.APPID, mediaId);
    }

    /**
     * 视频消息
     */
    public static String getVideoXml(String to, String from, String mediaId, String title, String desc){
        return MessageFormat.format(VOICE_XML_TEMPLATE, to, from,
                Timer.getCurrentTimestampMillis()/1000, mediaId, title, desc);
    }
    public static String getVideoXml(String to, String mediaId, String title, String desc){
        return getVideoXml(to, Constant.APPID, mediaId, title, desc);
    }

    /**
     * 音乐消息
     */
    public static String getMusicXml(String to, String from, String mediaId, String title, String desc){
        return MessageFormat.format(MUSIC_XML_TEMPLATE, to, from,
                Timer.getCurrentTimestampMillis()/1000, mediaId, title, desc);
    }
    public static String getMusicXml(String to, String mediaId, String title, String desc){
        return getMusicXml(to, Constant.APPID, mediaId, title, desc);
    }

    /**
     * 图文消息
     * 传入的items中，必须包含title, desc, pic, url
     */
    public static String getNewsXml(String to, String from, List<Map<String, String>> items){
        int total = 0;
        String itemsStr = "";
        if (items != null){
            for(Map<String, String> item: items){
                itemsStr += MessageFormat.format(ONE_NEW, item.get("title"), item.get("desc"), item.get("pic"), item.get("url"));
                total ++;
            }
        }
        return MessageFormat.format(NEWS_XML_TEMPLATE, to, from, Timer.getCurrentTimestampMillis()/1000, total, itemsStr);
    }

}
