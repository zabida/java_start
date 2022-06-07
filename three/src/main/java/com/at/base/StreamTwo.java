package com.at.base;

import java.util.Scanner;

public class StreamTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        while (scanner.hasNext()){
            String next = scanner.next();
            System.out.println(next);
            float v = Float.parseFloat(next);
            System.out.printf("%,.2f", v);
            System.out.println("----");
        }
        String s = String.format("%babc%s", Boolean.FALSE, "test");
        System.out.println(s);
    }
}
