package me.abnerlee.wechatAPI.api;

import me.abnerlee.utils.client.HttpClientUtils;
import me.abnerlee.utils.json.JsonConvert;
import me.abnerlee.wechatAPI.constant.UrlConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AbnerLee on 14-12-1.
 */

/**
 * 微信服务器IP地址查询接口
 */
public class IpAddressQuery {
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
        return getWechatIpList(UrlConstant.IP_LIST_URL, accessToken);
    }

    public static List<String> getWechatIpList(){
        return getWechatIpList(me.abnerlee.wechatAPItest.AccessTokenRequest.getAccessToken());
    }
}
