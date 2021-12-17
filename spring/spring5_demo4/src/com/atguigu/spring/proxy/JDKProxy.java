package com.atguigu.spring.proxy;

import com.atguigu.spring.dao.UserDao;
import com.atguigu.spring.dao.UserDaoImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        // 1.类加载器， 2.增强方法所在的类，这个类实现的接口，支持多个接口  3.实现接口InvocationHandler, 创建对象，写增强的方法
        UserDao dao  = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = dao.add(1, 2);
        System.out.println("result: " + add);
        String s = dao.update("3");
        System.out.println(s);
    }
}


class UserDaoProxy implements InvocationHandler {
    private Object obj;
    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    // 写增强的部分
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前执行。。。" + method.getName() + "传递参数。。。" + Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("方法之后执行。。。" + Arrays.toString(obj.getClass().getDeclaredFields()));
        return res;
    }
}