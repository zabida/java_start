package com.atguigu.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class BookProxy {
    private void before() {
        System.out.println("代理之前");
    }
}
