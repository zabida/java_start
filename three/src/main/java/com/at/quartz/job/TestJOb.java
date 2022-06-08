package com.at.quartz.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestJOb {
    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "tg1").startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(10)).build();
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
