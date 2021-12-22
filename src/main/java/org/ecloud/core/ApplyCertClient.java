package org.ecloud.core;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApplyCertClient {

    public static void main(String[] args) {
        EClientFinal client = new EClientFinal("yyz9304f0328d35d11c",
                "d3ca73fbb6817511202dab7cfa6702b7", "https://testapi.ecloudsign.cn");
        Map<String, String> param = new HashMap<>();
        param.put("info", "{\"type\":\"1\", \"cardType\":\"0\",\"idCardNum\":\"xx\",\"name\":\"xx\",\"mobilePhone\":\"15010961270\"}");
        param.put("isSign", "true");
        JSONObject object = client.commonRequst(param,EClientFinal.Method.POST, "/ecs/account/applyCert.jspa");
    }


}
