package me.abnerlee.utils.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 14-8-30.
 */

/**
 * Created by liwenjun on 14-4-12.
 */
public class JsonConvert {
    public static HashMap<String, String> jsonToMap(String json) {
        HashMap<String, String> map = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(json,
                    new TypeReference<HashMap<String, String>>() {
                    });
        } catch (IOException e) {
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
            e.printStackTrace();
        }

        return map;
    }


}
