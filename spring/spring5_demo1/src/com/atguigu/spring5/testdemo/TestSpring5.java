package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Order;
import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        BeanFactory context = new ClassPathXmlApplicationContext("bean1.xml");

        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Book book = context.getBean("book3", Book.class);
//        Book book = context.getBean("book2", Book.class);
//        Book book = context.getBean("book1", Book.class);
        book.testDemo();
    }

    @Test
    public void testOrder() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Order order = context.getBean("order", Order.class);
        order.testOrder();
    }
}
