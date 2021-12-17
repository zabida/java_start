package com.tuling.bootquartz;

import lombok.SneakyThrows;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class StartApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private Scheduler scheduler;

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        TriggerKey triggerKey = TriggerKey.triggerKey("trigger1", "group1");
        Trigger trigger = scheduler.getTrigger(triggerKey);
        if (trigger == null) {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                    .build();
            JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        }
    }
}
