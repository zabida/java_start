package com.atguigu.spring.service;


import com.atguigu.spring.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component(value = "userService")   // <bean id="userService" class="">
//@Service
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl2")  // 根据名字扫描, 不加默认按类型注入
    private UserDao userDao;

    public void add() {
        System.out.println("service add.... ");
        userDao.add();
    }
}

