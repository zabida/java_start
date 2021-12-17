package com.atguigu.spring5.bean;

public class Emp {
    private String name;
    private String age;
    private Dep dep;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public Dep getDep() {
        return dep;
    }

    public void testEmp() {
        System.out.println(this.name + " is " + this.age + ", and belong to " + dep.getName());
    }
}
