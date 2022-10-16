package com.juc.线程池;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadPoolExecutorDemo
 * @Description TODO
 * @Author bill
 * @Date 2022/4/18 0:14
 * @Version 1.0
 **/
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        AtomicInteger c = new AtomicInteger(1);
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                3,
                0,
                TimeUnit.MILLISECONDS,
                queue,
                r -> new Thread(r, "myThread" + c.getAndIncrement()),
                new ThreadPoolExecutor.CallerRunsPolicy());

    }

}
