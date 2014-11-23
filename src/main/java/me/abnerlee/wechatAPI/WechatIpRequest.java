package me.abnerlee.wechatAPI;

import me.abnerlee.utils.client.HttpClientUtils;
import me.abnerlee.utils.json.JsonConvert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-11-23.
 */
public class WechatIpRequest {
    public static List<String> getWechatIpList(String url, String accessToken){
        Map<String, String> params = new HashMap<String, String>();
        params.put("access_token", accessToken);

        Map<String, Object> body = JsonConvert.jsonToMapExtend(HttpClientUtils.request(url, params, null));
        if (body.get("errmsg") != null) {
            System.out.println(body.get("errmsg"));
            return null;
        } else {
            return (List<String>)body.get("ip_list");
        }
    }

    public static List<String> getWechatIpList(String accessToken){
        return getWechatIpList(Constant.IP_LIST_URL, accessToken);
    }

    public static List<String> getWechatIpList(){
        return getWechatIpList(AccessTokenRequest.getAccessToken());
    }

}
