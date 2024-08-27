package com.atguigu.boot.modules.my.req;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;


@Data
public class ImportParamProcessVersion2Req implements IExcelModel {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @Excel(name = "产品名称", fixedIndex = 0)
    @NotBlank(message = "不能为空")
    @Size(max = 20, message = "不得超过20位")
    private String dataName;

    @Excel(name = "产品描述", fixedIndex = 1)
    @NotBlank(message = "不能为空")
    @Size(min = 20, max = 200, message = "需为20—200字")
    private String dataContent;

    @Excel(name = "关键字，多个关键词中间英文逗号隔开“,”", fixedIndex = 2)
    @NotBlank(message = "不能为空")
    @Size(max = 15, message = "不得超过15位")
    private String keyWord;

    @Excel(name = "来源行业", fixedIndex = 3)
    @NotBlank(message = "不能为空")
    private String dataSource;

    @Excel(name = "数据主题", fixedIndex = 4)
    @NotBlank(message = "不能为空")
    private String industry;

    @Excel(name = "数据专区", fixedIndex = 5)
    @NotBlank(message = "不能为空")
    private String zones;

    @Excel(name = "数据组成成分—数据资源", fixedIndex = 6)
    @NotBlank(message = "不能为空")
    @Size(max = 500, message = "不得超过500位")
    private String dataResources;

    @Excel(name = "数据组成分—服务，选填", fixedIndex = 7)
    @Size(max = 500, message = "不得超过500位")
    private String serve;

    @Excel(name = "数据组成分—工具，选填", fixedIndex = 8)
    @Size(max = 500, message = "不得超过500位")
    private String tool;

    @Excel(name = "数据组成分—工具附件，选填", fixedIndex = 9)
    private String toolUrl;

    @Excel(name = "更新频率", fixedIndex = 10, replace = {"静态_1", "动态_2"}, addressList = true)
    @NotNull(message = "不能为空")
    @Pattern(regexp = "[12]", message = "请选择正确的更新频率，静态、动态")
    private String updateFrequencyType = "";

    @Excel(name = "更新频次", fixedIndex = 11, replace = {"实时更新_1", "每小时_2", "每日更新_3", "每周更新_4", "每月更新_5", "每半年更新_6", "每年更新_7"}, addressList = true)
    @Pattern(regexp = "1|2|3|4|5|6|7", message = "实时更新、每小时、每日更新、每周更新、每月更新、每半年更新、每年更新")
    private String updateFrequency;

    @Excel(name = "存储大小_存量，只写数字", fixedIndex = 12)
    @DecimalMax(value = "999999999", message = "不能超过9位数")
    private BigDecimal dataStore;

    @Excel(name = "单位", fixedIndex = 13, replace = {"MB_1", "GB_2", "TB_3", "PB_4"}, addressList = true)
    @NotBlank(message = "不能为空")
    private String dataStoreUnit;

    @Excel(name = "存储大小_预估增量，只写数字", fixedIndex = 14)
    @DecimalMax(value = "999999999", message = "不能超过9位数")
    private BigDecimal preDataStoreIncr;

    @Excel(name = "单位", fixedIndex = 15, replace = {"MB_1", "GB_2", "TB_3", "PB_4"}, addressList = true)
    @Pattern(regexp = "1|2|3|4|", message = "单位需为：MB、GB、TB、PB")
    private String preDataStoreIncrUnit = "";

    @Excel(name = "底层数据维度，只写数字", fixedIndex = 16)
    @NotNull(message = "不能为null")
    private Integer undDataDim;

    @Excel(name = "覆盖范围", fixedIndex = 17)
    @NotBlank(message = "不能为空")
    @Size(max = 150, message = "不得超过150位")
    private String coverage;

    @Excel(name = "应用场景", fixedIndex = 18)
    @NotBlank(message = "不能为空")
    private String applicationScene;

    @Excel(name = "自检报告文件", fixedIndex = 19)
    private String selfCheckUrl;

    @Excel(name = "样例报告文件", fixedIndex = 20)
    @NotBlank(message = "不能为空")
    private String sampleUrl;

    @Excel(name = "承诺函", fixedIndex = 21)
    private String commitmentLetterUrl;

    // 1：自行生产 2：协议取得 3：公开收集  99：其它来源
    @Excel(name = "来源证明", fixedIndex = 22)
    @NotBlank(message = "不能为空")
    private String dataFrom;

    @Excel(name = "错误原因", fixedIndex = 23)
    private String errorMsg;


}

