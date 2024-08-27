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
 * 签署协议类型
 */
@Getter
@AllArgsConstructor
public enum CorpusModeEnum {
    ONE("1","文本"),
    TWO("2","音频"),
    THREE("3","图像"),
    FOUR("4","视频"),
    ;
    private final String code;
    private final String name;

    public static String getNameByCode(String code) {
        return Arrays.stream(CorpusModeEnum.values())
                .filter(item -> item.getCode().equals(code))
                .findFirst().map(CorpusModeEnum::getName).orElse(StringUtils.EMPTY);
    }
    public static String getCodeByName(String name) {
        return EnumUtils.getEnum(CorpusModeEnum.class, name).getCode();
    }

    public static Map<String, String> getNameMap(){
        HashMap<String, String> map = new HashMap<>();
        for (CorpusModeEnum anEnum : values()) {
            map.put(anEnum.getName(), anEnum.getCode());
        }
        return map;
    }

    public static ArrayList<String> getAllName(){
        return Arrays.stream(values()).map(CorpusModeEnum::getName).collect(Collectors.toCollection(ArrayList::new));
    }

}
