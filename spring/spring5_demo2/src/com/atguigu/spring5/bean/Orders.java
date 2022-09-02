package com.atguigu.spring5.bean;

import com.atguigu.spring5.collections.Book;

public class Orders {

    public Orders() {
        System.out.println("第1步，构造方法");
    }
    String orderName;
    Book book;

    public void setOrderName(String orderName) {
        this.orderName = orderName;
        System.out.println("第2步，set方法 orderName");
    }

    public void setBook(Book book){
        this.book = book;
        System.out.println("第2步，set方法 book");
    }

    public void initMethod() {
        System.out.println("第3步，" + this.orderName + "订单初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第5步，销毁");
    }
}
