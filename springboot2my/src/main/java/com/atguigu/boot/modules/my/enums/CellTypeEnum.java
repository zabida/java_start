package com.atguigu.boot.modules.my.enums;

import lombok.AllArgsConstructor;
        import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CellTypeEnum {
    DATE("0", "日期"),
    DATETIME("1", "日期时间"),
    NUMERIC("2", "int型数字");

    private final String code;
    private final String value;
}
