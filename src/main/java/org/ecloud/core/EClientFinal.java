package org.ecloud.core;

import netscape.javascript.JSObject;
import org.ecloud.core.config.EnvConfig;
import org.ecloud.core.config.IApiEnv;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rob
 */
public class EClientFinal {

    EnvConfig env;

    public EClientFinal(IApiEnv envEnum) {
        this(envEnum.id(), envEnum.secrept(), envEnum.url());
    }

    public EClientFinal(String id, String secrept, String url) {
        this(new EnvConfig(id, secrept, url));
    }

    public EClientFinal(EnvConfig env) {
        this.env = env;
    }


   /* public JSObject applyCert() {
        Map<String, Object> param = new HashMap<>();

    }*/
}
