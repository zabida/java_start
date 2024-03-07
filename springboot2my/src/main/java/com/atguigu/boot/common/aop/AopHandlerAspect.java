package com.atguigu.boot.common.aop;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import cn.hutool.log.StaticLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Component    //把切面类加入到IOC容器中
@Aspect        //使之成为切面类
@Order(1)	//如果有多个 可以定义来控制顺序 数字越小执行顺序靠前
public class AopHandlerAspect {
    //日志 我是使用的hutool中的日志方法 你可以改为你自己的
    private Log logger = LogFactory.get();

    //为了记录执行时间 方便调试 如果不需要可以去掉
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    //定义一个切入点 我这里是从controller切入 不是从注解切入
    //详情看下方的 切入点表达式
    @Pointcut("execution(public * com.atguigu.boot.controller.*.*(..))")
    public void pointCut() {}

    //在进入方法前执行 可以对参数进行限制或者拦截
    //通常在这边做日志存储存到数据库中
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        logger.info("==================前置执行=====================>");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("请求来源： =》" + request.getRemoteAddr());
        logger.info("请求URL：" + request.getRequestURL().toString());
        logger.info("请求方式：" + request.getMethod());
        logger.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
        logger.info("==================前置执行完成==================>");
        startTime.set(System.currentTimeMillis());
    }
    //环绕执行
//定义需要匹配的切点表达式，同时需要匹配参数
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        StaticLog.info("==================方法环绕前置start=====================>");
        //这句必须有 往下执行方法
        Object result = pjp.proceed();

        StaticLog.info("==================方法环绕后置start=====================>");
        StaticLog.info("返回数据：{}", result);
        StaticLog.info("==================方法环绕end======================>");
        return result;
    }

    //在方法执行后执行 可以打印返回的数据 判断数据是否是自己需要的
    @After("pointCut()")
    public void after(JoinPoint point) {
        if (startTime.get() == null) {
            startTime.set(System.currentTimeMillis());
        }
        logger.info("==================后置执行======================>");
        logger.info("耗时（毫秒）：" + (System.currentTimeMillis() - startTime.get()));
        logger.info("返回数据：{}", point.getArgs());
        logger.info("==================后置执行完成==================>");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(JoinPoint point){
        logger.info("=================after return ===============");
    }
}
