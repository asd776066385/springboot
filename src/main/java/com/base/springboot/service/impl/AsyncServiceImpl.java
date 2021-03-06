package com.base.springboot.service.impl;

import com.base.springboot.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 异步任务
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    /**
     * @Async 让spring 自己开异步线程
     */
    @Async
    public void execTask(){
        System.out.println("进入任务。。。。。");
        try {
            System.out.println("任务处理中。。。。。。");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务处理完成。。。。。。");
    }
}
