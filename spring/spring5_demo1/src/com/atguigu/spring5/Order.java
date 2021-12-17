package com.atguigu.spring5;

public class Order {
    private String name;
    private String address;

    public Order(String name, String address) {
        this.address = address;
        this.name = name;
    }

    public void testOrder() {
        System.out.println(address + "::" + name);
    }
}
