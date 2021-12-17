package com.atguigu.spring5.autowire;

public class Empt {
    private String name;
    private Dept dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test(){
        System.out.println(this.name + "部门是：" + this.dept.getName());
    }
}
