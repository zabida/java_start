package com.tuling.quartz;

import lombok.SneakyThrows;
import org.quartz.*;

import java.util.Arrays;
import java.util.Date;


@DisallowConcurrentExecution  // 不允许同时执行
@PersistJobDataAfterExecution  // 持久化jobDataMap, 只对jobDetailData起作用，对trigger无效
public class MyJob implements Job {
    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("my_job execution" + new Date());
        JobDataMap jobDetailMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        System.out.println("-------------------------start at " + new Date());
        System.out.println("jobDetailMap: " + Arrays.toString(Arrays.stream(jobDetailMap.getKeys()).toArray()));
        System.out.println("triggerMap: " + Arrays.toString(Arrays.stream(triggerMap.getKeys()).toArray()));
//        Thread.sleep(5000);
        System.out.println("dataMap: " + Arrays.toString(Arrays.stream(jobDataMap.getKeys()).toArray()));
        System.out.println("-------------------end at " + new Date());
    }
}
