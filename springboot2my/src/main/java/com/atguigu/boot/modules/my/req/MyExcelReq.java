package com.atguigu.boot.modules.my.req;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyExcelReq implements IExcelModel {

    private Integer id;

    @Excel(name = "产品名称",fixedIndex = 0)
    @NotBlank(message = "不能为空")
    @Size(max = 30,message = "不得超过30位")
    private String dataName;

    @Excel(name = "英文名称，选填",fixedIndex = 1)
    @Pattern(regexp = "^[A-Za-z0-9]*$",message = "请输入英文")
    private String dataNameEn;

    @Excel(name = "公司名字", fixedIndex = 2)
    @Size(max = 5, message = "公司名字不超过5位")
    private String companyName;

    private String errorMsg;
}
