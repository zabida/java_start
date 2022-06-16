package com.at.base;

import org.apache.tomcat.jni.Local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateOne {
    public void trans() throws ParseException {
        // 时间对象转字符串
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = formatter.format(new Date());
        // 字符串转对象
        String dateStr = "2022-06-08";
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        formatter2.parse(dateStr);
        // 一年多少天
        SimpleDateFormat format = new SimpleDateFormat("D");
        System.out.println(format.format(new Date()));  // 当前第多少天
        // SimpleDateFormat线程不安全

        //使用LocalDatetime
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2022-06-10 13:21:10", ofPattern);
        LocalDateTime time = LocalDateTime.of(2022, 6, 22, 11, 12, 3);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime time1 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime plus = time1.plus(1, ChronoUnit.DAYS);
        // 指定本年当中第几天
        LocalDateTime dayOfYear = now.withDayOfYear(5);
        // 本月最后一天
        LocalDateTime lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        Duration between = Duration.between(now, lastDayOfMonth);
        long l = between.toDays(); // 相差天数
        long until = now.until(lastDayOfMonth, ChronoUnit.DAYS);  // 计算间隔
        // 格式化
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String s1 = now.format(pattern);
        String s2 = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s3 = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        // 解析
        LocalDateTime.parse(s1, pattern);
        LocalDateTime.parse(s2, DateTimeFormatter.BASIC_ISO_DATE);
        // 时间戳转换
        long second = now.atZone(ZoneId.systemDefault()).toEpochSecond();
        long milli = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(); // 毫秒
        // 时间戳转LocalDateTime
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault());
        LocalDateTime dateTime2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(second), ZoneId.systemDefault());

        //Date 转LocalDateTime
        LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // LocalDateTime 转LocalDate
        LocalDate localDate = localDateTime.toLocalDate();
        // LocalDate 转LocalDateTime
        LocalDate localDate1 = LocalDate.now();
        LocalDateTime dateTime1 = localDate1.atStartOfDay();

        // 比较先后
        boolean before = lastDayOfMonth.isBefore(now);
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

        LocalDateTime one = LocalDateTime.of(1993, 12, 1, 10, 9, 1);
        LocalDateTime now1 = LocalDateTime.of(1993,12,1,20,0,1);
        Duration between = Duration.between(one, now1);
        System.out.println(between.toDays());
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate parse = LocalDate.parse("20211115", pattern);
        System.out.println(parse.atStartOfDay());
    }
}
