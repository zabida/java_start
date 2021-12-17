package com.atguigu.spring.service;


import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBook(Book book){
        bookDao.add(book);
    }

    public void deleteBook(Book book){
        bookDao.delete(book);
    }

    public void updateBook(Book book){
        bookDao.update(book);
    }
}
