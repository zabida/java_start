package com.at.tool;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrabcBrokerProductSimpleInfoDto {
    @ApiModelProperty("价格列表")
    public String price_list;
    @ApiModelProperty("挂牌时间")
    public String listed_time;
    @ApiModelProperty("应用场景")
    public String application_scene;

    @ApiModelProperty(value = "产品名称")
    public String data_name;
    @ApiModelProperty("交易模式")
    public String trading_pattern;
    public String try_or_not;

    @ApiModelProperty(value = "产品类型")
    public String data_type;

    @ApiModelProperty("挂牌代码")
    public String listed_product_code;

    @ApiModelProperty("挂牌代码")
    public Integer limit_num;
}
