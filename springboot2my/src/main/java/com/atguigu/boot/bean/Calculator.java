package com.atguigu.boot.bean;


import com.atguigu.boot.anonotation.Check;

import java.util.Map;

public class Calculator {
    @Check
    public static int add(int a, int b){
        return a + b;
    }

    @Check
    public static int div(int a, int b) {
        return a / b;
    }

    @Check
    public static int mut(int a, int b) {
        return a * b;
    }

    public int cal() {

        return 1;
    }
}
