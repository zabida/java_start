package com.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//@Mapper
//public interface BookDao {
//    @Select("select * from book where id = #{id}")
//    Book getBookById(Integer id);
//}

@Mapper
public interface BookDao extends BaseMapper<Book> {
}