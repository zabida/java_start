package com.at.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class JsonAndObj {
    public static void test(){
        HashMap<String, Double> map = new HashMap<>();
        map.put("Alex", 3500D);
        map.put("Elic", 1234D);
        String jsonString = JSON.toJSONString(map);
        Object parse = JSON.parse(jsonString);

        // 确定反序列化结果的泛型参数
        HashMap<String, Double> fromJson = JsonAndObj.getFromJson(jsonString,
                new TypeReference<HashMap<String, Double>>() {});
    }

    public static <T> T getFromJson(String str, TypeReference<T> typeReference){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(str, typeReference);
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
