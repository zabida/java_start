package com.atguigu.spring.dao;

import com.atguigu.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    void delete(Book book);
}
