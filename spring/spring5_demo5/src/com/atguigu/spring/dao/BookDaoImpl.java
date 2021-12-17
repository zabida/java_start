package com.atguigu.spring.dao;

import com.atguigu.spring.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(Book book) {
        String sql = "insert into t_book values(?, ?, ?)";
        Object[] args = {book.getUserId(), book.getUserName(), book.getuStatus()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void update(Book book) {
        String sql = "update t_book set user_name=?, u_status=? where user_id=?";
        Object[] args = {book.getUserName(), book.getuStatus(), book.getUserId()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    @Override
    public void delete(Book book) {
        String sql = "delete from t_book where user_id=?";
        int update = jdbcTemplate.update(sql, book.getUserId());
        System.out.println(update);
    }
}
