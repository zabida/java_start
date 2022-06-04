package com.atguigu.boot.controller;


import com.atguigu.boot.enums.CellTypeEnum;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;


//@ResponseBody
//@Controller
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello, spring!";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(value = "myfile") MultipartFile file) throws Exception {
        HashMap<String, Integer> map = this.readExcel(file);
        return map.toString();
    }

    private HashMap<String, Integer> readExcel(MultipartFile file) throws Exception {
        if (file == null ) {
            throw new Exception("文件为空");
        }
        Workbook workbook = null;
        try {
            InputStream inputStream = file.getInputStream();
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
        HashMap<String, Integer> map = new HashMap<>();
        Sheet sheet = workbook.getSheetAt(0);
        int rowLen = sheet.getLastRowNum();
        for (int i = 1; i <= rowLen; i= i+1) {
            Row row = sheet.getRow(i);
            Cell dateCell = row.getCell(0);
            Cell numCell = row.getCell(1);
            String dateStr = trans(dateCell, CellTypeEnum.DATE.getCode());
            String numStr = Objects.requireNonNull(trans(numCell, CellTypeEnum.NUMERIC.getCode()));
            int num = Double.valueOf(numStr).intValue();
            if (map.containsKey(dateStr)){
                throw new Exception("数据错误，excel日期数据重复:" + dateStr);
            } else {
                map.put(dateStr, num);
            }
        }
        System.out.println(map);
        return map;
    }

    private String trans(Cell cell, String type) throws Exception {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (CellTypeEnum.DATE.getCode().equals(type)) {
                    System.out.println(cell);
                    Date dateCellValue = cell.getDateCellValue();
                    String s = new SimpleDateFormat("yyyyMMdd").format(dateCellValue);
                    return s;
                } else if (CellTypeEnum.NUMERIC.getCode().equals(type)) {
                    return String.valueOf(cell.getNumericCellValue());
                };
                break;
            case Cell.CELL_TYPE_STRING:
                if (CellTypeEnum.DATE.getCode().equals(type)) {
                    String s = cell.getStringCellValue();
                    try {
                        new SimpleDateFormat("yyyyMMdd").parse(s);
                        return s;
                    } catch (ParseException e) {
                        System.out.println("异常" + e.getMessage());
                    }
                } else if (CellTypeEnum.NUMERIC.getCode().equals(type)) {
                    return cell.getStringCellValue();
                }
                break;
            default:
                break;
        }
        return null;
    }
}
