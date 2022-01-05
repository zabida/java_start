package com.ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssmp.dao.BookDao;
import com.ssmp.domain.Book;
import com.ssmp.service.IBookService;
import org.springframework.stereotype.Service;


@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

}
