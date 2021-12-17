package com.atguigu.spring5;


public class Book {

    private String name;

    private String author;

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void testDemo() {
        System.out.println(name + "::" + author);
    }
}
