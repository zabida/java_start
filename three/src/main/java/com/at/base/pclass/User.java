package com.at.base.pclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String sex;
    private int age;
    private Info info;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Info{
        public String address;
        public String level;
    }
}
