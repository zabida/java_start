package com.at.tool.wx.wxapi;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HttpClient {

    private static OkHttpClient client = new OkHttpClient().newBuilder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10,TimeUnit.SECONDS)
            .readTimeout(10,TimeUnit.SECONDS)
            .build();


    public static String get(String url){
        return get(url, null);
    }

    public static String get(String url, Map<String, String> params) {
        Response execute = null;
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        if (Objects.nonNull(params)) {
            for (String key : params.keySet()) {
                urlBuilder.addQueryParameter(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .method("GET", null)
                .url(urlBuilder.build())
                .build();
        try {
            execute = client.newCall(request).execute();
            if (ObjectUtil.isNotNull(execute) && execute.isSuccessful()){
                return execute.body().string();
            }
        } catch (IOException e) {
            log.error("http get 请求失败--{}",e);
        }
        return null;
    }

    public static byte[] getBytes(String url){
        Response execute = null;
        Request request = new Request.Builder()
                .method("GET",null)
                .url(url)
                .build();
        try {
            execute = client.newCall(request).execute();
            if (ObjectUtil.isNotNull(execute) && execute.isSuccessful()){
                return execute.body().bytes();
            }
        } catch (IOException e) {
            log.error("http get 请求失败--{}",e);
        }
        return null;
    }


    public static String post(String url,String body){
        return post(url, null, body);
    }

    public static String post(String url, Map<String, String> params, String body){
        Response execute = null;
        HttpUrl.Builder urlBuilder = Objects.requireNonNull(HttpUrl.parse(url)).newBuilder();
        if (Objects.nonNull(params)) {
            for (String key : params.keySet()) {
                urlBuilder.addQueryParameter(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .method("POST", RequestBody.create(body, MediaType.get("application/json")))
                .url(urlBuilder.build())
                .build();
        try {
            execute = client.newCall(request).execute();
            if (ObjectUtil.isNotNull(execute) && execute.isSuccessful()){
                return execute.body().string();
            }
        } catch (IOException e) {
            log.error("http post 请求失败--{}",e);
        }
        return null;

    }
}
