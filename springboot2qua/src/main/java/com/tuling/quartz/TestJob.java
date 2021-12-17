package com.tuling.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestJob {
    public static void main(String[] args) {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("job", "jobDetail")
                .usingJobData("hei", "ha")
                .build();

        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "trigger1")
                .usingJobData("trigger", "trigger")
                .startNow()
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
//                                .withIntervalInMinutes(1)
                                .withIntervalInSeconds(3).withRepeatCount(4)
                )
                .build();
        try{
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
