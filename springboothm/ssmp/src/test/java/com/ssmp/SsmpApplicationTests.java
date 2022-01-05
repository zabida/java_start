package com.ssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssmp.dao.BookDao;
import com.ssmp.domain.Book;
import com.ssmp.service.BookService;
import com.ssmp.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SsmpApplicationTests {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookService bookService;
    @Autowired
    private IBookService iBookService;

    @Test
    void contextLoads() {
        Book bookById = bookDao.selectById(1);
    }

    @Test
    void save(){
        Book book = new Book();
        book.setName("one");
        book.setType("类型");
        book.setDescription("测试保存");
        bookDao.insert(book);
    }

    @Test
    void testGetPage() {
        IPage page = new Page<Book>(2, 1);
        bookDao.selectPage(page, null);
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        String name = "123";
        wrapper.like(name != null, Book::getName, name);
        for (Book book : bookDao.selectList(wrapper)) {
            System.out.println(book);
        }
        bookDao.selectPage(new Page<Book>(1,2), wrapper);
    }

    @Test
    void testGetBy2() {
        Book byId = iBookService.getById(1);
        bookService.getById(1);
    }
}
