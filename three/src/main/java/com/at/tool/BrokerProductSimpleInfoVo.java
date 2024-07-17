package com.at.tool;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrokerProductSimpleInfoVo {
    private String dataName;
    private String listedProductCode;
    private String dataType;
    private String listedTime;
    private String applicationScene;
    private String priceList;
}
