package com.atguigu.boot.anonotation;

// 先javac 该注解文件，得到class编译文件，然后javap 反编译该class文件，可以看到实际的内容
// 以下写法其实相当于
// public interface com.atguigu.boot.anonotation.MyAnno extends java.lang.annotation.Annotation {
// 所以@interface是语法糖
public @interface MyAnno {
    public abstract String show();
    public abstract int show2();
    public abstract MyAnno2 show3();
    public abstract String[] strs();
}
