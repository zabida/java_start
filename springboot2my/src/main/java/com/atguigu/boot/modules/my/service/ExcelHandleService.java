package com.atguigu.boot.modules.my.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface ExcelHandleService {
    HashMap<String, Integer> readeExcel(MultipartFile file) throws Exception;

    String readeExcelByEasy(MultipartFile file, String type) throws Exception;

    String readeExcelByEasy2(MultipartFile file, String type);
}
