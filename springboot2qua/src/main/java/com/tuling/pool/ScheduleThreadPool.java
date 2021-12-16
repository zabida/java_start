package com.tuling.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 4; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new Task("task-" + i), 0, 2, TimeUnit.SECONDS);
        }
    }
}


class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public Task() {
    }

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