package com.atguigu.boot.anonotation;


import java.lang.annotation.*;

@Target(value = {ElementType.TYPE,ElementType.METHOD})  // 作用范围：类、方法
@Retention(RetentionPolicy.RUNTIME)   // 作用阶段，一共source, class runtime 三个阶段
@Documented    //是否可以加载到javadoc文档里
@Inherited  // 子类不需要明示声明，自动继承  父类上的注解
public @interface MyAnno3 {
    public abstract String className();
    public abstract String methodName();

}
