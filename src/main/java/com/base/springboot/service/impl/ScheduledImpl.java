package com.base.springboot.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledImpl {

    /**
     * 配置定时任务
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void testScheduled(){
        System.out.println("定时输出,间隔5s");
    }
}
