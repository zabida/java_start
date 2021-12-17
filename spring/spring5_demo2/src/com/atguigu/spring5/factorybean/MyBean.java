package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.collections.Course;
import org.springframework.beans.factory.FactoryBean;

import java.util.ArrayList;

public class MyBean  implements FactoryBean<Course> {
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
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
