package me.abnerlee.util.json;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AbnerLee on 14-8-30.
 * Json和对象之间的转化
 */
public class JsonConvert {
    private static ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LogManager.getLogger(JsonConvert.class.getName());

    public static void checkMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();
        }
    }

    public static <T> T jsonToObject(String json, T t) {
        checkMapper();
        try {
            return mapper.readValue(json, new TypeReference<T>() {
            });
        } catch (IOException e) {
            logger.error("json转对象错误：" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public static HashMap<String, String> jsonToMap(String json) {
        HashMap<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
            logger.error("jsonToMap :: json转对象错误：" + e.getMessage());
            e.printStackTrace();
        }

        return map;
    }

    public static HashMap<String, Object> jsonToMapExtend(String json) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, Object>>() {
                    });
        } catch (IOException e) {
            logger.error("jsonToMapExtend :: json转对象错误：" + e.getMessage());
            e.printStackTrace();
        }

        return map;
    }

    public static String mapToJson(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(map);
        } catch (IOException e) {
            logger.error("mapToJson :: map转json错误：" + e.getMessage());
            e.printStackTrace();
        }
        return json;
    }


}
