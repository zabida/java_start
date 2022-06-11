package com.at.base;

import java.util.Map;
import java.util.Random;

public class MathOne {
    public static void main(String[] args) {
        double random = Math.random(); // [0, 1)
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

        double ceil = Math.ceil(3.2);  // 4.0
        System.out.println(ceil);
        double floor = Math.floor(3.2);  // 3.0
        System.out.println(floor);
        long round = Math.round(3.2);  // 3
        long round1 = Math.round(3.8);  // 4
        System.out.println(round + ":" + round1);
        double pow = Math.pow(5, 3);// 5的3次方
        System.out.println(pow);
        double sqrt = Math.sqrt(64); // 8 开方
        int abs = Math.abs(-45);  // 绝对值

        Random rand = new Random();
        //随机生成[0,1)之间的double类型的数据
        System.out.println(rand.nextDouble());
        //随机生成int类型允许范围之内的整型数据
        System.out.println(rand.nextInt());
        //随机生成[0,1)之间的float类型的数据
        System.out.println(rand.nextFloat());
        //随机生成false或者true
        System.out.println(rand.nextBoolean());
        //随机生成[0,10)之间的int类型的数据
        System.out.print(rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据
        System.out.print(20 + rand.nextInt(10));
        //随机生成[20,30)之间的int类型的数据（此种方法计算较为复杂）
        System.out.print(20 + (int) (rand.nextDouble() * 10));
    }
}
