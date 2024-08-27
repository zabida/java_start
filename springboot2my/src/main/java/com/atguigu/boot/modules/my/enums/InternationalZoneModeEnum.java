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
public enum InternationalZoneModeEnum {
    ONE("1","产品包含境外数据"),
    TWO("2","产品已向境外出售"),
    THREE("3","产品计划境外出售"),
    ;
    private final String code;
    private final String name;

    public static String getNameByCode(String code) {
        return Arrays.stream(InternationalZoneModeEnum.values())
                .filter(item -> item.getCode().equals(code))
                .findFirst().map(InternationalZoneModeEnum::getName).orElse(StringUtils.EMPTY);
    }
    public static String getCodeByName(String name) {
        return EnumUtils.getEnum(InternationalZoneModeEnum.class, name).getCode();
    }

    public static Map<String, String> getNameMap(){
        HashMap<String, String> map = new HashMap<>();
        for (InternationalZoneModeEnum modeEnum : values()) {
            map.put(modeEnum.getName(), modeEnum.getCode());
        }
        return map;
    }

    public static ArrayList<String> getAllName(){
        return Arrays.stream(values()).map(InternationalZoneModeEnum::getName).collect(Collectors.toCollection(ArrayList::new));
    }
}
