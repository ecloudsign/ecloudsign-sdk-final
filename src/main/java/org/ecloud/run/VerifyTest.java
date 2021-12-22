package org.ecloud.run;

import com.alibaba.fastjson.JSONObject;
import org.ecloud.core.EClientFinal;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class VerifyTest {

    @Test
    public void getTaskId() {
        EClientFinal client = new EClientFinal("yyzzsb8f179pf8mejiz0",
                "d617737f239f85972de27feca1aa0dd9", "https://huidu-api.ecloudsign.com");

        JSONObject object = client.commonRequst(new HashMap<>(), EClientFinal.Method.POST, "/ecs/face/getTaskId.jspa");
        System.out.println(object);
    }

    @Test
    public void ocrVerify() {
        EClientFinal client = new EClientFinal("yyzt3eq4x1kn52od2c",
                "27s9m84b19epu8l9", "https://testapi.ecloudsign.cn");

        client = new EClientFinal("yyzzsb8f179pf8mejiz0",
                "d617737f239f85972de27feca1aa0dd9", "https://huidu-api.ecloudsign.com");

        Map<String, String> param = new HashMap<>();
        param.put("userId","1091");
        param.put("taskId","202112221718361504");
        param.put("frontImage","xxx");
        param.put("backImage","xxx");
        JSONObject object = client.commonRequst(param, EClientFinal.Method.POST, "/ecs/face/ocrVerify.jspa");
        System.out.println(JSONObject.toJSONString(object));
    }


    @Test
    public void getDownloadEvidenceUrl() {
        EClientFinal client = new EClientFinal("yyz9304f0328d35d11c",
                "d3ca73fbb6817511202dab7cfa6702b7", "https://testapi.ecloudsign.cn");
        Map<String, String> param = new HashMap<>();
        param.put("mobilePhone","15010961260");
        param.put("contractNum","33E212EF8AE92C5E");
        JSONObject object = client.commonRequst(param, EClientFinal.Method.POST, "/ecs/contract/getDownloadEvidenceUrl.jspa");
        System.out.println(JSONObject.toJSONString(object));
    }
}
