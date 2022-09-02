package com.atguigu.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userDaoImpl2")   // 设置别名
public class UserDaoImpl2 implements UserDao {

    @Value(value = "abc")
    private String name;

    @Override
    public void add() {
        System.out.println("userDaoImpl2: " + name);
    }

}