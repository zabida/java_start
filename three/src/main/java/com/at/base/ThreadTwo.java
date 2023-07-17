package com.at.base;

import com.at.base.pclass.Account;

public class ThreadTwo extends Thread{

    int drawingNum; // 取多少钱
    Account account; // 要取钱的账户
    int expenseTotal; // 总共取的钱数

    public ThreadTwo(int drawingNum, Account account) {
        super();
        this.drawingNum = drawingNum;
        this.account = account;
    }

    @Override
    public void run() {
//        synchronized (account) {
            if (account.money - drawingNum < 0) {
                System.out.println(this.getName() + "取款，余额不足！");
                return;
            }
            try {
                Thread.sleep(1000); // 判断完后阻塞。其他线程开始运行。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money -= drawingNum;
            expenseTotal += drawingNum;
//        }
        System.out.println(this.getName() + "--账户余额：" + account.money);
        System.out.println(this.getName() + "--总共取了：" + expenseTotal);
    }

    public static void main(String[] args) {
        Account a1 = new Account(100, "高");
        ThreadTwo draw1 = new ThreadTwo(80, a1);// 定义取钱线程对象；
        ThreadTwo draw2 = new ThreadTwo(80, a1);// 定义取钱线程对象；
        draw1.start(); // 你取钱
        draw2.start(); // 你老婆取钱
        // 加了线程同步，类似python线程加锁
        // 未加线程同步的，同时扣取了2次钱, 前面的 校验没挡住
    }

}
