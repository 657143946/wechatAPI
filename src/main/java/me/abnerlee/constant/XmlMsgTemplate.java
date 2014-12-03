package me.abnerlee.constant;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 发送给微信服务器
 * XML格式模板
 * 用MessageFormat进行填充
 */
public class XmlMsgTemplate {
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
}
