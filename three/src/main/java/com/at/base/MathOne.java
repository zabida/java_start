package com.at.base;

public class MathOne {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(random);
        float a = 334784620;
        System.out.println(a);
        int m = 8;
        int n = 8;
        int c = 2 * m++;   // 16
        int d = 2 * ++n;   // 18
        int i = d >> 10;
        System.out.println(i);
        StringBuilder builder = new StringBuilder("123");
        builder.append("12");
        builder.append(129);
        String s = builder.toString();
        System.out.println(s);

    }
}
