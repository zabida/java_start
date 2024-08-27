package com.atguigu.boot.modules.my.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author Jiayx
 * @date 2024/7/5 15:48
 */
@Getter
@AllArgsConstructor
public enum ZonesTypeEnum {
    CORPUS_ZONE("corpus_zone","语料专区"),
    INTERNATIONAL_ZONE("international_zone","国际专区"),
    PUBLIC_ZONE("public_zone","公共数据专区"),
    BIOMEDICAL_ZONE("biomedical_zone","生物医药专区"),
    OTHER("other","以上均不属于"),
    ;
    private final String code;
    private final String name;

    public static String getNameByCode(String code) {
        return Arrays.stream(ZonesTypeEnum.values())
                .filter(item -> item.getCode().equals(code))
                .findFirst().map(ZonesTypeEnum::getName).orElse(StringUtils.EMPTY);
    }
    public static String getCodeByName(String name) {
        return EnumUtils.getEnum(ZonesTypeEnum.class, name).getCode();
    }
}
