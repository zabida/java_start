package com.atguigu.boot.bean;


import com.atguigu.boot.anonotation.MyAnno3;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

public class Pet {
    Pet(String name) {
    }
    Pet() {}

    @MyAnno3(className = "com.atguigu.boot.User", methodName = "fun")
    public void sound(String a) throws NoSuchMethodException {
         Method sound = this.getClass().getMethod("sound", String.class);
        MyAnno3 anno3 = sound.getAnnotation(MyAnno3.class);
        String className = anno3.className();
        String methodName = anno3.methodName();
        System.out.println("className: " + className + " , method: " + methodName);
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Pet pet = new Pet();
        pet.sound("a");
    }
}
