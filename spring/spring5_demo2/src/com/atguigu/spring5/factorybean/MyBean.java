package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.collections.Course;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;


// 工厂bean，有别于普通bean
// 创建类，实现FactoryBean接口
// 实现接口里的方法，在实现方法中定义返回的bean类型
public class MyBean  implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        ArrayList<String> list = new ArrayList<String>();
        list.add("center");
        list.add("ABC");
        course.setBoolList(list);
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

class MyBeanTest {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        MyBean bean = context.getBean(MyBean.class);
        Course course = bean.getObject();
        System.out.println(course);
    }
}