package com.atguigu.boot.modules.my.utils;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;

import cn.hutool.json.JSONUtil;
import com.atguigu.boot.modules.my.handler.RegisterPV2Handler;
import com.atguigu.boot.modules.my.req.ImportDataSetParamReq;
import com.atguigu.boot.modules.my.req.ImportParamProcessVersion2Req;
import com.atguigu.boot.modules.my.req.MyExcelReq;
import com.atguigu.boot.modules.my.resp.RegistrationTemplateProcessVersion2Resp;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EasyPoiUtil {

    @Value("${gofastdfs.upload.open_path:open}")
    private String openPath;
    @Resource
    RegisterPV2Handler registerPV2Handler;

    public RegistrationTemplateProcessVersion2Resp analysisRegistrationTemplateProcessVersion2(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        Assert.isTrue(StrUtil.isNotEmpty(filename), "文件名不存在");
        Assert.isTrue(filename.endsWith(".xls")|| filename.endsWith(".xlsx"), "文件格式错误");
        ImportParams params = new ImportParams();
        //去掉第一行标题
        params.setTitleRows(1);
        // 校验文件格式
        params.setNeedVerify(true);
        params.setVerifyHandler(registerPV2Handler);
        ExcelImportResult<ImportParamProcessVersion2Req> result;
        try {
            result= ExcelImportUtil.importExcelMore(file.getInputStream(), ImportParamProcessVersion2Req.class, params);
        } catch (Exception e){
            log.error("解析文件异常", e);
            throw new Exception("解析excel文件异常");
        }
        List<ImportParamProcessVersion2Req> okList = result.getList();
        List<ImportParamProcessVersion2Req> failList = result.getFailList();
        Assert.isTrue(okList.size() + failList.size() <= 200,
                StrUtil.format("单次批量导入数据量不可超过{}", 200)
        );
        RegistrationTemplateProcessVersion2Resp resp = new RegistrationTemplateProcessVersion2Resp();
        resp.setImportParamProcessVersion2ReqsOk(okList);
        resp.setImportParamProcessVersion2ReqsFail(failList);
        return resp;
    }

    public byte[] getErrorExcelOutPutSteam(List<ImportParamProcessVersion2Req> list) throws Exception {
        ExportParams params = new ExportParams("产品描述", "登记模板", ExcelType.XSSF);
        params.setStyle(ExcelStyleUtil.class);
        Workbook workbook = ExcelExportUtil.exportExcel(params, ImportParamProcessVersion2Req.class, list);
        workbook.getSheet("登记模板");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            workbook.write(outputStream);
        }catch (Exception e){
            log.error("输出流写入异常", e);
            throw new Exception("输出流写入异常");
        }
        return outputStream.toByteArray();
    }

    public void errorExcelExport(List<ImportParamProcessVersion2Req> okList, List<ImportParamProcessVersion2Req> failList) throws Exception {
        if (CollectionUtil.isNotEmpty(okList)){
            failList.addAll(okList);
        }
        byte[] outPutSteam = getErrorExcelOutPutSteam(failList);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outPutSteam);

        String fileName = "ERROR"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ ".xlsx";
        // 创建附件、添加attachment记录
        try {
            fileName = URLEncoder.encode(fileName, "UTF8");
        }catch (Exception e){
            log.error("文件名解析异常", e);
            throw new Exception("文件名解析异常");
        }
    }
}
