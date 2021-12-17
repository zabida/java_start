package com.atguigu.spring.proxy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    // 相同切入点抽取
    @Pointcut(value = "execution(* com.atguigu.spring.service.User.add(..))")
    public void pointDemo() {
    }

//    @Before(value = "execution(* com.atguigu.spring.service.User.add(..))")
    @Before(value = "pointDemo()")
    public void before(){
        System.out.println("before.....");  // 前置通知
    }

//    @After(value = "execution(* com.atguigu.spring.service.User.add(..))")
    @After(value = "pointDemo()")
    public void after() {
        System.out.println("after......");
    }

//    @AfterThrowing(value = "execution(* com.atguigu.spring.service.User.add(..))")
    @After(value = "pointDemo()")
    public void afterThrow() {
        System.out.println("afterThrow......");
    }

    // 环绕通知
//    @Around(value = "execution(* com.atguigu.spring.service.User.add(..))")
    @Around(value = "pointDemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }
}
