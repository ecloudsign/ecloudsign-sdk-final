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

    /**
     * 吴丽英 建设银行 6217001930061279155 35020419830308652X 13606900677
     */
    @Test
    public void getDownloadEvidenceUrl() {
        EClientFinal client = new EClientFinal("yyzzsb8f179pf8mejiz0",
                "d617737f239f85972de27feca1aa0dd9", "https://huidu-api.ecloudsign.com");

        Map<String, String> bankinfo = new HashMap<>();
        bankinfo.put("realName","吴丽英");
        bankinfo.put("bankNumber","6217001930061279155");
        bankinfo.put("idCardNumber","35020419830308652X");
        bankinfo.put("mobile","13606900677");
        bankinfo.put("verifyType","4");

        Map<String, String> param = new HashMap<>();
        param.put("bankInfo",JSONObject.toJSONString(bankinfo));
        JSONObject object = client.commonRequst(param, EClientFinal.Method.POST, "/ecs/auth/bankVerify.jspa");
        System.out.println(JSONObject.toJSONString(object));
    }



}
