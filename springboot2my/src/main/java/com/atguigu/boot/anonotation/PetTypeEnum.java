package com.atguigu.boot.anonotation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum PetTypeEnum {
    CAT("cat", "猫"),
    DOG("dog", "狗"),
    ;
    private String name;
    private String value;
}
