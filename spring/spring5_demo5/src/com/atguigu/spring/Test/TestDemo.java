package com.atguigu.spring.Test;

import com.atguigu.spring.entity.Book;
import com.atguigu.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    @Test
    public void testDemo() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUserName("java");
        book.setuStatus("a");
        bookService.addBook(book);
    }
    @Test
    public void testUpdate() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUserName("java");
        book.setuStatus("c");
        bookService.updateBook(book);
    }
    @Test
    public void testDelete() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        Book book = new Book();
        book.setUserId("1");
        book.setUserName("java");
        book.setuStatus("a");
        bookService.deleteBook(book);
    }
}
