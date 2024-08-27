package com.atguigu.boot.modules.my.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jiayx
 * @date 2024/7/5 15:44
 */
@Getter
@AllArgsConstructor
public enum BiomedicalZoneModeEnum {
    ONE("1","医药专利"),
    TWO("2","试验测试"),
    THREE("3","行业分析"),
    FOUR("4","医保数据"),
    FIVE("5","其他"),
    ;
    private final String code;
    private final String name;

    public static String getNameByCode(String code) {
        return Arrays.stream(BiomedicalZoneModeEnum.values())
                .filter(item -> item.getCode().equals(code))
                .findFirst().map(BiomedicalZoneModeEnum::getName).orElse(StringUtils.EMPTY);
    }
    public static String getCodeByName(String name) {
        return EnumUtils.getEnum(BiomedicalZoneModeEnum.class, name).getCode();
    }

    public static Map<String, String>getNameMap(){
        HashMap<String, String> map = new HashMap<>();
        for (BiomedicalZoneModeEnum anEnum : values()) {
            map.put(anEnum.getName(), anEnum.getCode());
        }
        return map;
    }

    public static ArrayList<String> getAllName(){
        return Arrays.stream(values()).map(BiomedicalZoneModeEnum::getName).collect(Collectors.toCollection(ArrayList::new));
    }
}
