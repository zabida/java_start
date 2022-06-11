package com.at.base;

import java.util.Arrays;

public class ArrayOne {
    public static void test(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        int[] kk = new int[] {1,2,3};  // 初始化直接赋值
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

        // 深拷贝，将a数组从第10位开始拷贝到b的第10位，向后拷30个
        System.arraycopy(a, 10, b,10, 30);

        // main方法中的args其实就是命令行参数
        System.out.println(Arrays.toString(args));

        Arrays.sort(a);  // 内置的排序，使用的快排
        int ind = Arrays.binarySearch(a, 3);// 二分查找，先sort才行

        int[] d = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(d));  // [1,2,3,4,5,6,7,8]
        Arrays.fill(d, 2,4, 100);
        System.out.println(Arrays.toString(d));  // [1,2,100,100,5,6,7,8]

        // 多维数组
        Object[] a1 = {1001, "wuze1", 181, "man1"};
        Object[] a2 = {1002, "wuze2", 182, "man2"};
        Object[] a3 = {1003, "wuze3", 183, "man3"};
        Object[][] aa = new Object[3][];  // 注意是 Object[3][] 不是Object[][3]
        aa[0] = a1;
        aa[1] = a2;
        aa[2] = a3;
        System.out.println(Arrays.toString(aa));
    }
}
