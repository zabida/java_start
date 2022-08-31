package com.at.base;

import java.util.Arrays;
import java.util.stream.IntStream;


// 多线程常规写法，定义一个类，放入Thread类中
public class ThreadOne implements Runnable{
    String name;
    boolean live = true;
    public void run(){
        int i = 0;
        while (live){
            System.out.println(Thread.currentThread().getThreadGroup() + Thread.currentThread().getName() + i);
            i += 1;
        }
    }

    public void terminate(){
        live = false;
    }

    public static void main(String[] args) {
        ThreadOne one1 = new ThreadOne();
        ThreadOne one2 = new ThreadOne();
        Thread thread1 = new Thread(one1);
        thread1.start();
        Thread thread2 = new Thread(one2);
        thread2.start();
        for (int i: IntStream.range(1,100).toArray()) {
            System.out.println(i);
        }
        one1.terminate();
        one2.terminate();
    }
}
