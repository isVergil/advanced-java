package com.javabasic._day11_Socket网络编程NIO.TCP通信四;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HandlerSocketThreadPool
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 15:29
 * @Version 1.0
 * // 线程池处理类
 **/
public class HandlerSocketThreadPool {
    // 线程池
    private ExecutorService executor;

    // 线程池：3个线程  100个
    public HandlerSocketThreadPool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(
                maxPoolSize,
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        this.executor.execute(task);
    }
}
