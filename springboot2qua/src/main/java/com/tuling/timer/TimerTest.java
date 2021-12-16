package com.tuling.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        for (int i=0; i< 4; i++){
            FooTimerTask task = new FooTimerTask("foo" + i);
            timer.schedule(task, new Date(), 20000);
//            timer.scheduleAtFixedRate(task, new Date(), 20000);
        }
    }
}


class  FooTimerTask extends TimerTask {
    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    public FooTimerTask() {}

    public void run() {
        try {
            System.out.println("now is " + this.name + ", start:" + new Date());
            Thread.sleep(3000);
            System.out.println("now is " + this.name + ", end:" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}