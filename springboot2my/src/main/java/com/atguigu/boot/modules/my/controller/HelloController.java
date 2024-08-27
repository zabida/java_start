package com.atguigu.boot.modules.my.controller;


import com.atguigu.boot.modules.my.service.ExcelHandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;


//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @Autowired
    ExcelHandleService excelHandleService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello, spring!";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "myfile") MultipartFile file) throws Exception {
        HashMap<String, Integer> map = excelHandleService.readeExcel(file);
        return map.toString();
    }

    @PostMapping("/upload2")
    public String upload2(@RequestParam(value = "file") MultipartFile file,
                          @RequestParam(value = "type") String type) throws Exception {
        return excelHandleService.readeExcelByEasy(file, type);
    }

    @PostMapping("/upload3")
    public String upload3(@RequestParam(value = "file") MultipartFile file,
                          @RequestParam(value = "type") String type) throws Exception {
        return excelHandleService.readeExcelByEasy2(file, type);
    }

}
