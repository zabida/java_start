package com.atguigu.boot.anonotation;


import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

@SuppressWarnings("all")
@Slf4j
public class AnnoDemo {
    @Deprecated
    public void show() {

    }

    @MyAnno(show = "1", show2 = 1, show3 = PetTypeEnum.DOG, strs = {"abc", "231"})
    public void show2() {

    }

    public static void main(String[] args) {
        try {
            AnnoDemo annoDemo = new AnnoDemo();
            Method show2 = annoDemo.getClass().getMethod("show2");
            MyAnno annotation = show2.getAnnotation(MyAnno.class);
            System.out.println("1   " + annoDemo);
            show2.getDeclaredAnnotations(); // Declared 自身的属性，不带这个的是获取所有属性，包括父类的
            MyAnno2 annotation1 = show2.getAnnotation(MyAnno2.class);
            System.out.println("2   " + annotation1);
            String[] strs = annotation.strs();
            System.out.println("3   " + strs);
        } catch (Exception e){
            log.info("", e);
        }

    }
}
