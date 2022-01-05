package com;

import com.ithm.HmApplication;
import com.ithm.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


// 测试类会在同包下找SpringBootConfiguration注解，找不到报异常，可以显式指定Application
//@SpringBootTest
@SpringBootTest(classes = HmApplication.class)
class HmApplicationTests {
    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println("test.....");
        bookDao.save();
    }

}
