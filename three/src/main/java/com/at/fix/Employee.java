package com.at.fix;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Employee {
    private Integer age;
    private String sex;
    private LocalDate hireDay;
    private static int nextId = 1;

    Employee(){
    }

    Employee(Integer age, String sex, int year, int mon, int day){
        this.age = age;
        this.sex = sex;
        this.hireDay = LocalDate.of(year, mon, day);
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public static void main(String[] args) {
        Employee nan = new Employee(18, "nan", 1990, 12, 1);
        System.out.println(nan.hireDay);
        LocalDate hireDay = nan.getHireDay();
        nan.hireDay = LocalDate.now();
    }
}
