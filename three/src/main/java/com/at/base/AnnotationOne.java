package com.at.base;


import java.lang.annotation.*;

public class AnnotationOne {
    @Deprecated
    public void test(){

    }
    @MyAnnotation
    public void test1(){
    }

    @AnnotationTwo(age = 18)
    public void test2(){

    }
}



// 定义一个自己的注解, 这是语法， public @interface name{}, 里面是方法其实是声明的配置参数
// 有四大元注解, 可以点进 Deprecated 进去看看是怎么定义的
// Target注解有参数 value(), 是个数组
@Target(value = {ElementType.TYPE, ElementType.METHOD})  // 可以作用于类或方法
// 表示注解在什么地方有效 runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)
// 是否将注解生成在javadoc中
@Documented
// 子类可以继承父类注解
@Inherited
@interface MyAnnotation{

}