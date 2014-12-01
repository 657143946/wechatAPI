package me.abnerlee.wechatAPI.xml_to_entity;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 消息实体，会将收到的xml转换成这个类的实例
 */
public class MsgEntity {
    /**
     * 接收来自微信的消息
     * 图片，语音，视频，地理位置，链接，点击事件
     */

    // 所有接口共有字段
    private String ToUserName = "";
    private String FromUserName = "";
    private String CreateTime = "";
    private String MsgType = "";
    private String MsgId = "";

    // 普通消息
    private String Content = "";  // 文字消息
    private String PicUrl = "";  // 图片消息
    private String MediaId = "";  // 图片消息，语音消息，视频消息
    private String Format = "";  // 语音消息
    private String ThumbMediaId = "";  // 视频消息
    private String Location_X = "";  // 地理位置
    private String Location_Y = "";  // 地理位置
    private String Scale = "";  // 地理位置
    private String Label = "";  // 地理位置
    private String Title = "";  // 链接消息
    private String Description = "";  // 链接消息
    private String Url = "";  // 链接消息

    // 事件推送
    private String Event = "";  // 事件推送事件都有的
    private String EventKey = "";  //扫描带参数二维码事件, 点击菜单拉取消息时的事件推送
    private String Ticket = "";  //扫描带参数二维码事件
    private String Latitude = "";  //上报地理位置事件
    private String Longitude = "";  //上报地理位置事件
    private String Precision = "";  //上报地理位置事件

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }
}
