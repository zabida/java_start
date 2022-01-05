package com.ithm.controller;

// REST模式

import com.ithm.MyDatasource;
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
}