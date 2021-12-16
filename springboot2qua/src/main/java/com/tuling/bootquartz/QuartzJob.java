package com.tuling.bootquartz;

import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;


@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class QuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        try {
            Thread.sleep(2000);
            System.out.println(context.getScheduler().getSchedulerInstanceId());

            System.out.println("taskName=" + context.getJobDetail().getKey().getName());
            System.out.println("执行时间=" + new Date());
        } catch (InterruptedException | SchedulerException e) {
            e.printStackTrace();
        }
    }
}
