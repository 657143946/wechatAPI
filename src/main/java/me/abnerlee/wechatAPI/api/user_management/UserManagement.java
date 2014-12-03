package me.abnerlee.wechatAPI.api.user_management;

/**
 * Created by AbnerLee on 14-12-1.
 */

import me.abnerlee.constant.UrlConstant;
import me.abnerlee.util.client.HttpClientUtils;
import me.abnerlee.util.json.JsonConvert;
import me.abnerlee.wechatAPI.api.AccessTokenRequest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用户管理相关接口
 */
public class UserManagement {

    /**
     * 获取用户列表原始数据返回
     */
    private static Map<String, Object> getUserListOriginal(String accessToken, String nextOpenId) {
        /** GET参数 **/
        Map<String, String> getParams = new HashMap<String, String>();
        /** access_token **/
        getParams.put("ACCESS_TOKEN", accessToken);
        /** next_openid **/
        if (nextOpenId != null && !"".equals(nextOpenId.trim())) {
            getParams.put("next_openid", nextOpenId);
        }

        String body = HttpClientUtils.postParams(UrlConstant.USER_LIST_URL, getParams, null);
        Map<String, Object> map = JsonConvert.jsonToMapExtend(body);
        if (map.get("data") == null) {
            System.out.println("获取关注者列表error：" + map.get("errmsg"));
            return null;
        } else {
            return map;
        }
    }

    /**
     * 获取所有的关注者
     */
    public static List<String> getUserList(String accessToken) {
        List<String> openIds = new LinkedList<String>();

        String nextOpenId = null;
        int total = -1;
        do {
            Map<String, Object> map = getUserListOriginal(accessToken, nextOpenId);
            if (map != null) {
                openIds.addAll((List<String>) ((Map<String, Object>) map.get("data")).get("openid"));
                nextOpenId = (String) map.get("next_openid");
            } else {
                break;
            }
        } while (total > openIds.size());
        return openIds;
    }

    /**
     * 获取所有的关注者
     */
    public static List<String> getUserList() {
        return getUserList(AccessTokenRequest.getAccessToken());
    }

}
