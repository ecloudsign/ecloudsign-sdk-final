package org.ecloud.core.verify.tencent;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.faceid.v20180301.FaceidClient;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationRequest;
import com.tencentcloudapi.faceid.v20180301.models.BankCard4EVerificationResponse;
import lombok.Data;
import org.junit.Test;



public class VerifyTest {

    static String tencentSecretId = "AKIDb091dy2oJYXFgy0lFTQ6VdVpxqY1FDvN";
    static String tencentSecretKey = "EBrHQIuGMBk3B4h4C5i5D5h390by6yaw";

    @Test
    public void  BankCard4EVerificationRequestTest() throws TencentCloudSDKException {
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
        Credential cred = new Credential(tencentSecretId, tencentSecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("faceid.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        FaceidClient client = new FaceidClient(cred, "", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        BankCard4EVerificationRequest req = new BankCard4EVerificationRequest();

        req.setIdCard("350126197701262822");
        req.setName("陈依妹");
        req.setBankCard("6217001820033391925");
        req.setPhone("15880178671");

        // 返回的resp是一个BankCard4EVerificationResponse的实例，与请求对象对应
        BankCard4EVerificationResponse resp = client.BankCard4EVerification(req);
        // 输出json格式的字符串回包
        System.out.println(BankCard4EVerificationResponse.toJsonString(resp));
    }
}
