package com.at.tool.excel;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.chinadep.common.api.ApiException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

public class EasyPoiTool {

    public void analysisRegistrationTemplate() throws Exception{
        String filePath = "C:\\Users\\WZE\\Downloads\\ERROR20231219110347.xls";
        File file1 = new File(filePath);
        FileInputStream inputStream = new FileInputStream(file1);

        if (file1.getTotalSpace() == 0){
            throw new ApiException("文件不能为空");
        }

        String ofname = file1.getName();

        int begin = ofname.lastIndexOf(".");
        int last = ofname.length();
        String a = ofname.substring(begin, last);
        if(!(a.endsWith(".xlsx")||a.endsWith(".xls"))){
            throw new ApiException("文件格式不正确");
        }
        ImportParams params = new ImportParams();
        //去掉第一行标题
        params.setTitleRows(1);
        // 校验文件格式
        params.setNeedVerify(true);
        // 校验URL地址
        params.setVerifyHandler(new ImportParamVerifyHandler());
        ExcelImportResult<ImportParamReq> result = ExcelImportUtil.importExcelMore(inputStream, ImportParamReq.class,params);
        if(result.getList().size()+result.getFailList().size()>200){
            throw new ApiException("产品数量不能超过两百");
        }
        if(result.getList().size()==0 && result.getFailList().size()==0){
            throw new ApiException("不能上传空文件");
        }
        List<ImportParamReq> result1 = new LinkedList<>();
        for (ImportParamReq req : result.getList()) {
            if (!req.getUri().contains("http") && req.getUri().contains("https")) {
                req.setUri("https://" + req.getUri());
            }
            if (!req.getUriTest().contains("http") && req.getUriTest().contains("https")) {
                req.setUriTest("https://" + req.getUriTest());
            }
            result1.add(req);
        }
        List<ImportParamReq> failList = result.getFailList();
        System.out.println(failList);
    }

    public static void main(String[] args) throws Exception {
        EasyPoiTool tool = new EasyPoiTool();
        tool.analysisRegistrationTemplate();
    }
}
