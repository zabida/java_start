package com.at.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.at.base.pclass.User;
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

        User user = new User();
        user.setAge(18);
        user.setName("haha");
        User.Info info = new User.Info();
        info.setAddress("上海");
        user.setInfo(info);
        String s = JSON.toJSONString(user);
        Object fromJson1 = JsonAndObj.getFromJson(s);
        ObjectMapper objectMapper = new ObjectMapper();
        User user1 = objectMapper.convertValue(fromJson1, new TypeReference<User>() {
        });
        System.out.println(user1);
    }

    public static <T> T getFromJson(String str){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // 这里时没法直接转成T对象的，泛型在运行时jdk无法知道其类型。所以转出来的是默认的LinkedHashMap。想转成具体的类型，需要在使用的时候再传入具体的类型，convert成具体对象
            return objectMapper.readValue(str, new TypeReference<T>() {
            });
        } catch (IOException e){
            throw new RuntimeException();
        }
    }

    // public static <T> T getFromJson2(String str){
        // return JSON.parseObject(str, T.class);  // 这种的为啥不行,泛型在运行时无法知道类型，这种写法不对的
    // }

    public static void main(String[] args) {
        JsonAndObj.test();
    }
}
