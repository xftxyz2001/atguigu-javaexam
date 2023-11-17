package com.xftxyz.weatherapi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "weather")
public class WeatherApiConfig {
    private String appcode;
    private String url;

    public String getAppcode() {
        return appcode;
    }

    public String getUrl() {
        return url;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
