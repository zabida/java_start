package com.at.tool.excel;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import org.apache.commons.lang3.StringUtils;

public class ImportParamVerifyHandler implements IExcelVerifyHandler<ImportParamReq>  {

    @Override
    public ExcelVerifyHandlerResult verifyHandler(ImportParamReq importParamReq) {

        //设置默认验证为true
        ExcelVerifyHandlerResult excelVerifyHandlerResult = new ExcelVerifyHandlerResult(true);

        String uri = importParamReq.getUri();
        if (StringUtils.isNotBlank(uri)) {
            if (StringUtils.contains(uri, "http") && !StringUtils.contains(uri, "https")) {
                excelVerifyHandlerResult.setSuccess(false);
                excelVerifyHandlerResult.setMsg("生产地址API格式错误，必须包含https");
                return excelVerifyHandlerResult;
            }
        }

        String uriTest = importParamReq.getUriTest();
        if (StringUtils.isNotBlank(uriTest)) {
            if (StringUtils.contains(uriTest, "http") && !StringUtils.contains(uriTest, "https")) {
                excelVerifyHandlerResult.setSuccess(false);
                excelVerifyHandlerResult.setMsg("测试地址API格式错误，必须包含https");
                return excelVerifyHandlerResult;
            }
        }

        return excelVerifyHandlerResult;
    }
}
