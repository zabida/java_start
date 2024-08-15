package com.atguigu.boot.modules.my.req;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * 数据集导入参数
 */
@Data
public class ImportDataSetParamReq implements IExcelModel {

    private Integer id;

    @Excel(name = "产品名称",fixedIndex = 0)
    @NotBlank(message = "不能为空")
    @Size(max = 30,message = "不得超过30位")
    private String dataName;

    @Excel(name = "英文名称，选填",fixedIndex = 1)
    @Pattern(regexp = "^[A-Za-z0-9]*$",message = "请输入英文")
    private String dataNameEn;


    @Excel(name = "产品描述",fixedIndex = 2)
    @NotBlank(message = "不能为空")
    @Size(max = 150,message = "不得超过150位")
    private String dataContent;

    @Excel(name = "关键字，多个关键词中间英文逗号隔开“,”",fixedIndex = 3)
    @NotBlank(message = "不能为空")
    @Size(max = 15,message = "不得超过15位")
    private String keyWord;

    @Excel(name = "模态（可多选，最多4）",fixedIndex = 4)
    @Size(max = 150,message = "可多选，最多4")
    private String categoryOne;

    @Excel(name = "应用领域，（可多选，最多3）",fixedIndex = 5)
    @Size(max = 150,message = "可多选，最多3")
    private String categoryTwo;

    @Excel(name = "更新频率",fixedIndex = 6,replace = {"静态_1", "动态_2"},addressList = true)
    @NotBlank(message = "不能为空")
    @Pattern(regexp = "[12]",message = "请选择正确的更新频率")
    private String updateFrequencyType="";

    @Excel(name = "更新频次",fixedIndex = 7,replace = {"实时更新_1","每小时_2","每日更新_3", "每周更新_4","每月更新_5","每半年更新_6","每年更新_7"},addressList = true)
    private String updateFrequency;

    @Excel(name = "存储大小_存量，只写数字",fixedIndex = 8)
    @DecimalMax(value = "999999999",message = "不能超过9位数")
    private BigDecimal dataStore;

    @Excel(name = "单位",fixedIndex = 9,replace = {"MB_1", "GB_2", "TB_3" ,"PB_4"},addressList = true)
    private String dataStoreUnit="";

    @Excel(name = "存储大小_预估增量，只写数字",fixedIndex = 10)
    @DecimalMax(value = "999999999",message = "不能超过9位数")
    private BigDecimal preDataStoreIncr;

    @Excel(name = "单位",fixedIndex = 11,replace = {"MB_1", "GB_2", "TB_3" ,"PB_4"},addressList = true)
    private String preDataStoreIncrUnit="";

    @Excel(name = "底层数据维度，只写数字",fixedIndex = 12)
//    @Max(value = 999999999,message = "不能超过9位数")
    private Integer undDataDim;

    @Excel(name = "覆盖范围",fixedIndex = 13)
    @NotBlank(message = "不能为空")
    @Size(max = 50,message = "不得超过50位")
    private String coverage;

    @Excel(name = "数据画像，选填",fixedIndex = 14)
//    @NotBlank(message = "不能为空")
    @Size(max = 10000,message = "不得超过10000位")
    private String dataProfile;

    @Excel(name = "使用描述，选填",fixedIndex = 15)
//    @NotBlank(message = "不能为空")
    @Size(max = 10000,message = "不得超过10000位")
    private String usageDesc;


    @Excel(name = "使用目的",fixedIndex = 16)
    @NotBlank(message = "不能为空")
    @Size(max = 60,message = "不得超过60位")
    private String purposeType;

    @Excel(name = "使用者资质",fixedIndex = 17)
    @NotBlank(message = "不能为空")
    @Size(max = 110,message = "不得超过110位")
    private String userReqType;

    @Excel(name = "时间限制",fixedIndex = 18)
    @NotBlank(message = "不能为空")
    @Size(max = 60,message = "不得超过60位")
    private String usagePresDef;

    @Excel(name = "不得转让规则",fixedIndex = 19)
    @NotBlank(message = "不能为空")
    @Size(max = 60,message = "不得超过60位")
    private String rulesType;

    @Excel(name = "其他限制",fixedIndex = 20)
    @NotBlank(message = "不能为空")
    @Size(max = 60,message = "不得超过60位")
    private String otherRestrictions;

    private String errorMsg;

}

