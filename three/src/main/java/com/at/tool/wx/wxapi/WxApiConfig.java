package com.at.tool.wx.wxapi;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Data
public class WxApiConfig {
    private List<App> apps;
    private Api api;

    @Data
    public static class Api{
        private String accessToken;
        private String releaseList;
    }

    @Data
    public static class App {
        private String name;
        private String appid;
        private String secret;
    }

    public Map<String, App> appMap(){
        return apps.stream().collect(Collectors.toMap(App::getName, Function.identity()));
    }
    public App getAppByName(String appName){
        for (App app : apps) {
            if (app.name.equals(appName)){
                return app;
            }
        }
        return null;
    }
}
