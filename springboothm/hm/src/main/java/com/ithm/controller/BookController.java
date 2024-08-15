package com.ithm.controller;

// REST模式

import cn.hutool.core.bean.BeanUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ithm.MyDatasource;
import com.ithm.req.TestReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
//@RestController  // 上面的合二为一
@RequestMapping("/book")
public class BookController {

    @Value("${hobby}")
    private String hobby;

    @Value("${users[0].name}")
    private String users;

    @Autowired
    private Environment env;

    @Autowired
    private MyDatasource myDatasource;

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println(id);
        System.out.println(hobby);
        System.out.println(users);
        System.out.println("------------------");
        System.out.println(env);
        System.out.println(env.getProperty("hobby"));
        System.out.println("------------------");
        System.out.println(myDatasource.toString());
        return "spring is running, get id is " + id;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println(id);
        return "spring is running, delete id is " + id;
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    public String post(Integer id) {
        return "spring is running, post id is " + id;
    }

    @RequestMapping(path = "/my", method = RequestMethod.POST)
    public String post1(@RequestBody TestReq req) {
        Object one = req.getOne();
        // ObjectMapper objectMapper = new ObjectMapper();
        // Map<String, Object> map = objectMapper.convertValue(req.getOne().get(0), new TypeReference<Map<String, Object>>() {});
        // Object o = map.get("items");
        // Map<String, Object> map1 = objectMapper.convertValue(o, new TypeReference<Map<String, Object>>() {});
        // Object o1 = map1.get("properties");
        // Map<String, Object> map2 = objectMapper.convertValue(o1, new TypeReference<Map<String, Object>>() {});
        // for (String s : map2.keySet()) {
        //     Object o2 = map2.get(s);
        //     Map<String, Object> item = objectMapper.convertValue(o2, new TypeReference<Map<String, Object>>() {});
        //     String o3 = String.v alueOf(item.get("type"));
        //     String o4 = String.valueOf(item.get("title"));
        //     System.out.println(o2 + o3 + o4);
        // }
        Map<String, Object> map = BeanUtil.beanToMap(one);
        Object o = map.get("items");
        Map<String, Object> map1 = BeanUtil.beanToMap(o);
        Object o1 = map1.get("properties");
        Map<String, Object> map2 = BeanUtil.beanToMap(o1);
        for (String s : map2.keySet()) {
            Object o2 = map2.get(s);
            Map<String, Object> item = BeanUtil.beanToMap(o2);
            String o3 = String.valueOf(item.get("type"));
            String o4 = String.valueOf(item.get("title"));
            System.out.println(o2 + o3 + o4);
        }

        return null;
    }
}