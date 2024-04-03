package com.at.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class JsonAndObj {
    public static void test(){
        HashMap<String, Double> map = new HashMap<>();
        map.put("Alex", 3500D);
        map.put("Elic", 1234D);
        String jsonString = JSON.toJSONString(map);
        HashMap hashMap = JSON.parseObject(jsonString, HashMap.class);
        System.out.println(hashMap);

        // 确定反序列化结果的泛型参数
        HashMap<String, Double> fromJson = JsonAndObj.getFromJson(jsonString);
        System.out.println(fromJson);
    }

    public static <T> T getFromJson(String str){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(str, new TypeReference<T>() {});
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    public static <T> T getFromJson2(String str){
        return JSON.parseObject(str, T.class);  // 这种的为啥不行
    }

    public static void main(String[] args) {
        JsonAndObj.test();
    }
}
