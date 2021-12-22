package org.ecloud.core;


import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSONObject;
import com.ejlchina.okhttps.HTTP;
import com.ejlchina.okhttps.fastjson.FastjsonMsgConvertor;

import java.util.*;

import cn.hutool.core.date.DateUtil;



interface IApiEnv {

    public String appkey();

    public String secrept();

    public String url();
}
class EnvConfig implements IApiEnv {

    public String appkey;

    public String secrept;

    public String url;

    public EnvConfig(String appkey, String secrept, String url) {
        this.appkey = appkey;
        this.secrept = secrept;
        this.url = url;
    }

    @Override
    public String appkey() {
        return appkey;
    }

    @Override
    public String secrept() {
        return secrept;
    }

    @Override
    public String url() {
        return url;
    }
}


/**
 * @author rob
 */
public class EClientFinal {

    public static enum Method {

        /**
         * 请求类型
         */
        POST("POST"),
        GET("GET"),
        ;

        private final String method;

        Method(String method) {
            this.method = method;
        }

        public String method() {
            return this.method;
        }

    }

    EnvConfig env;

    public EClientFinal(IApiEnv envEnum) {
        this(envEnum.appkey(), envEnum.secrept(), envEnum.url());
    }

    public EClientFinal(String appkey, String secrept, String url) {
        this(new EnvConfig(appkey, secrept, url));
    }

    public EClientFinal(EnvConfig env) {
        this.env = env;
    }

    public static String getSignature(Map<String, String> paramMap, String secret) {
        List<String> paramKeys = new ArrayList<String>();
        for (Map.Entry entry : paramMap.entrySet()) {
            paramKeys.add(entry.getKey().toString());
        }
        // 对字段名进行排序，默认按字母的字典序排列
        Collections.sort(paramKeys);
        StringBuilder sb = new StringBuilder();
        //首先拼接上secret
        sb.append(secret);
        if (paramKeys.size() > 0) {
            for (String paramName : paramKeys) {
                if (!"signature".equals(paramMap.get(paramName))) {
                    String value = paramMap.get(paramName);
                    if (value != null && !"".equals(value)) {
                        sb.append(value);
                    }
                }
            }
        }
        //尾拼接上secret
        sb.append(secret);
        return MD5.create().digestHex(sb.toString()).toUpperCase();
    }

    private String getRandomNonce() {
        Random r = new Random();
        int random = r.nextInt(899999) + 100000;
        return Integer.toString(random);
    }

    public void addCommonParam(Map<String, String> paramMap) {
        paramMap.put("timestamp", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        paramMap.put("nonce", getRandomNonce());
        paramMap.put("v", "1.0");
        paramMap.put("appKey", env.appkey);

    }

    public JSONObject commonRequst(Map<String, String> paramMap, Method method, String path) {
        addCommonParam(paramMap);
        paramMap.put("signature", getSignature(paramMap, env.secrept));
        HTTP http = HTTP.builder().baseUrl(env.url).addMsgConvertor(new FastjsonMsgConvertor()).build();
        if (method == Method.POST) {
            return http.sync(path)
                    .addBodyPara(paramMap).post().getBody().toBean(JSONObject.class);
        } else if (method == Method.GET) {
            return http.sync(path)
                    .addUrlPara(paramMap).get().getBody().toBean(JSONObject.class);
        }else {
            throw new RuntimeException("咱不支持其他Method方式的调用");
        }
    }
}
