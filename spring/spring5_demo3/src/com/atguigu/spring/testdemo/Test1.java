package com.atguigu.spring.testdemo;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class c = Class.forName("com.atguigu.spring.dao.UserDaoImpl");
        Constructor constructor = c.getDeclaredConstructor();
        Object o = constructor.newInstance();
        System.out.println(o.toString());
    }
}
