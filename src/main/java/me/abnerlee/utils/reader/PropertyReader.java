package me.abnerlee.utils.reader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Properties;

/**
 * Created by liwenjun on 14-4-11.
 */
public class PropertyReader {
    public static HashMap<String, String> readProperties(String filePath, String... keys) {
        HashMap pro = new HashMap();
        InputStream in = PropertyReader.class.getClassLoader().getResourceAsStream(filePath);
        Properties p = new Properties();
        try {
            p.load(new InputStreamReader(in, "utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (keys.length != 0) {
            for (String key : keys) {
                pro.put(key, p.getProperty(key, null));
            }
        } else {
            for (Object key : p.keySet()) {
                String k = (String) key;
                pro.put(k, p.getProperty(k, ""));
            }
        }
        return pro;
    }

}
