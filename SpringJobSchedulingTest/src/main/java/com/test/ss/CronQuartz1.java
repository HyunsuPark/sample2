package com.test.ss;

import java.text.SimpleDateFormat;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class CronQuartz1 extends QuartzJobBean{
    @Override
    protected void executeInternal(JobExecutionContext arg0)
            throws JobExecutionException {
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println("Cron trigger 1 (5 second): current time = " + sdf.format(time));
    }
 
}