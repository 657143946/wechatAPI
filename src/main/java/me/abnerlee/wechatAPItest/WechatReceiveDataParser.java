package me.abnerlee.wechatAPItest;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created by Administrator on 14-11-23.
 */
public class WechatReceiveDataParser {

    public static WechatReceiveData getMsgEntity(String strXml) {
        WechatReceiveData msg = null;
        try {
            if (strXml.length() <= 0 || strXml == null)
                return null;
            // 将字符串转化为XML文档对象
            Document document = DocumentHelper.parseText(strXml);
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();
            // 遍历所有结点
            msg = new WechatReceiveData();
            //利用反射机制，调用set方法
            //获取该实体的元类型
            Class<?> c = WechatReceiveData.class;
            msg = (WechatReceiveData) c.newInstance();//创建这个实体的对象
            while (iter.hasNext()) {
                    Element ele = (Element) iter.next();
                try{
                    //获取set方法中的参数字段（实体类的属性）
                    Field field = c.getDeclaredField(ele.getName());
                    //获取set方法，field.getType())获取它的参数数据类型
                    Method method = c.getDeclaredMethod("set" + ele.getName(), field.getType());
                    //调用set方法
                    method.invoke(msg, ele.getText());
                }catch (Exception e) {
                    System.out.println("xml to object: no this field: " + ele.getName());
                }
            }
        } catch (Exception e) {
            System.out.println("xml 格式异常: " + strXml);
            e.printStackTrace();
            return null;
        }
        return msg;
    }

    public static WechatReceiveData getMsgEntity(InputStream is) {
        String body = null;
        try {
            body = IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
            body = "";
        }
        return getMsgEntity(body);
    }

}
