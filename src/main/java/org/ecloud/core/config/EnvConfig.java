package org.ecloud.core.config;

public class EnvConfig implements IApiEnv {

    public String id;

    public String secrept;

    public String url;

    public EnvConfig(String id, String secrept, String url) {
        this.id = id;
        this.secrept = secrept;
        this.url = url;
    }

    @Override
    public String id() {
        return id;
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
