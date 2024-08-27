package com.atguigu.boot.modules.my.resp;

import com.atguigu.boot.modules.my.req.ImportParamProcessVersion2Req;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationTemplateProcessVersion2Resp {
    @ApiModelProperty(value="成功的数据")
    private List<ImportParamProcessVersion2Req> importParamProcessVersion2ReqsOk;
    @ApiModelProperty(value="失败的数据")
    private List<ImportParamProcessVersion2Req> importParamProcessVersion2ReqsFail;
}
