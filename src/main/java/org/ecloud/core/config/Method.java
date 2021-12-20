package org.ecloud.core.config;

public enum Method {

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