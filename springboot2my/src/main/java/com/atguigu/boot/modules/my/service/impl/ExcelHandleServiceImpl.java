package com.atguigu.boot.modules.my.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.sax.ExcelSaxUtil;
import com.atguigu.boot.modules.my.enums.CellTypeEnum;
import com.atguigu.boot.modules.my.req.MyExcelReq;
import com.atguigu.boot.modules.my.resp.RegistrationTemplateProcessVersion2Resp;
import com.atguigu.boot.modules.my.service.ExcelHandleService;
import com.atguigu.boot.modules.my.req.ImportDataSetParamReq;
import com.atguigu.boot.modules.my.utils.EasyPoiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Slf4j
public class ExcelHandleServiceImpl implements ExcelHandleService {
    @Autowired
    EasyPoiUtil easyPoiUtil;

    @Override
    public HashMap<String, Integer> readeExcel(MultipartFile file) throws Exception {
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
            case NUMERIC:
                if (CellTypeEnum.DATE.getCode().equals(type)) {
                    System.out.println(cell);
                    Date dateCellValue = cell.getDateCellValue();
                    String s = new SimpleDateFormat("yyyyMMdd").format(dateCellValue);
                    return s;
                } else if (CellTypeEnum.NUMERIC.getCode().equals(type)) {
                    return String.valueOf(cell.getNumericCellValue());
                };
                break;
            case STRING:
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

    @Override
    public String readeExcelByEasy(MultipartFile file, String type) throws Exception {
        String filename = file.getOriginalFilename();
        assert filename != null;
        if(!(filename.endsWith(".xlsx")||filename.endsWith(".xls"))){
            throw new Exception("文件格式不正确");
        }
        ImportParams params = new ImportParams();
        // 去掉第一行标题
        params.setTitleRows(1);
        // 校验文件格式
        params.setNeedVerify(true);
        ExcelImportResult<ImportDataSetParamReq> resultDataSet = ExcelImportUtil.importExcelMore(file.getInputStream(), MyExcelReq.class, params);
        log.info(JSONUtil.toJsonStr(resultDataSet));

        // 落下异常excel文件
        ExportParams exportParams = new ExportParams("产品描述", "登记模板", ExcelType.XSSF);
        // exportParams.setStyle();
        List<MyExcelReq> list = new ArrayList<>();
        MyExcelReq one = new MyExcelReq();
        one.setDataName("产品名称1");
        list.add(one);
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, MyExcelReq.class, list);
        Sheet sheet = workbook.getSheet("登记模板");
        sheet.removeMergedRegion(0);
        sheet.getRow(2).getCell(2).setCellValue("file");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        byte[] byteArray = outputStream.toByteArray();
        if (StrUtil.equals("fs", type)){
            // 上传到文件服务器
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            InputStreamResource isr = new InputStreamResource(inputStream, "aaa.xlsx");
            Map<String, Object> map = new HashMap<>();
            map.put("file", isr);
            map.put("path", "/open");
            map.put("output", "json");
            HttpRequest httpRequest = HttpRequest.post("").header("Authorization", "");
            String body = httpRequest.form(map).execute().body();
            log.info(body);
        } else if (StrUtil.equals("local", type)) {
            // 保存在本地
            File file1 = new File("aa.xlsx");
            try(FileOutputStream fileOutputStream = new FileOutputStream(file1)){
                fileOutputStream.write(outputStream.toByteArray());
            }
        }
        return JSONUtil.toJsonStr(resultDataSet);
    }

    @Override
    public String readeExcelByEasy2(MultipartFile file, String type) {
        try{
            RegistrationTemplateProcessVersion2Resp resp = easyPoiUtil.analysisRegistrationTemplateProcessVersion2(file);
        } catch (Exception e){
            log.error("异常", e);
        }
        return "123";
    }
}
