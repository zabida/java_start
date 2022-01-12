package com.ssmp.controller;


import com.ssmp.common.BaseController;
import com.ssmp.domain.Book;
import com.ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController extends BaseController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(value = "id") Integer id){
        logger.info("cesassssssss!!!!!!!!!!!");
        return bookService.getById(id);
    }
}
