package com.at.fix;

import java.util.ArrayList;
import java.util.Arrays;

public class Fan {
    public static <E> void printArray(ArrayList<E> inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static <E> void print(ArrayList<E> arrayList) {
        //
        System.out.println(arrayList.toString());
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b"));
//        Fan fan = new Fan();
//        fan.printArray(list);
        Fan.printArray(list);
    }
}
