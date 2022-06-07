package com.at.base;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class DateOne {
    public void plus(){

    }
    public static void main(String[] args) {
        // LocalDate类 类似日历，可以提供很多功能
        LocalDate date = LocalDate.of(1993, 12, 1);
        LocalDate now = LocalDate.now();
        LocalDate date1 = now.plusDays(3);
        LocalDate date2 = now.plusMonths(1);
        // 获取当月的第一天日期,minus减去
        LocalDate date3 = now.minusDays(now.getDayOfMonth() -1);
        // 并且知道这月第一天是周几
        DayOfWeek dayOfWeek = date3.getDayOfWeek();
        int value = dayOfWeek.getValue();
        // 获取这月最后一天
        LocalDate lastDay = now.plusMonths(1).minusDays(now.getDayOfMonth());
    }
}
