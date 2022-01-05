package com.sql;

import com.sql.dao.BookDao;
import com.sql.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SqlApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        Book byId = bookDao.getById(1);
        System.out.println(byId);
    }
}
