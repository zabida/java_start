package com.atguigu.spring.dao;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userDaoImpl")   // 设置别名 相当于设置bean的id值，默认自动装配按type来
public class UserDaoImpl implements UserDao{

    @Value(value = "abc")
    private String name;

    @Override
    public void add(){
        System.out.println("userDaoImpl: " + name);
    }
}
