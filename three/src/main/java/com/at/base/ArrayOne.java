package com.at.base;

import java.util.Arrays;

public class ArrayOne {
    public static void test(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        int[] a = new int[50];  // 初始化的默认每个数都是0
        a[1] = 2;  // 赋值
        System.out.println("下标1的数是：" + a[1]);

        a = new int[100];  // 不用初始化变量a，可以直接重新设置数组a，即匿名数组重新赋值给a
        System.out.println("重新赋值后, 下标1的数是：" + a[1]);
        System.out.println("下标80的数是：" + a[80]);

        // 数组拷贝，正常的也是浅拷贝
        int[] b = a;
        a[80] = 80;
        System.out.println("a下标80的修改为数字80了，现在b的下标80的数是：" + b[80]);

        // 深拷贝用
        int[] c= Arrays.copyOf(a, a.length);

        // main方法中的args其实就是命令行参数
        System.out.println(Arrays.toString(args));

        Arrays.sort(a);  // 内置的排序，使用的快排
    }
}
