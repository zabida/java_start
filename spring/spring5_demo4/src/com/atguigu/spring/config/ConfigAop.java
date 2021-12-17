package com.atguigu.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.atguigu.spring"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
