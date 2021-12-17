package com.atguigu.spring5.collections;

import java.util.Arrays;
import java.util.List;

public class Course {
    private String[] book;
    private List<String> boolList;
    private List<Book> books;

    public void setBook(String[] book) {
        this.book = book;
    }

    public void setBoolList(List<String> boolList) {
        this.boolList = boolList;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void test(){
        System.out.println(Arrays.toString(this.book));
        System.out.println(boolList);
        System.out.println(books);
    }
}
