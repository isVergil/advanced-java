package com.juc.线程池;

import java.util.concurrent.*;

/**
 * @ClassName ExecutorServiceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/31 14:45
 * @Version 1.0
 **/
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1l,  //1 s 时间线程池空闲就收缩
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),    //等候区
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy());  //线程超过 8 个直接报异常
                //new ThreadPoolExecutor.CallerRunsPolicy());   ////线程超过 8 个把多出的线程回退给调用者
                //new ThreadPoolExecutor.DiscardOldestPolicy());   //线程超过 8 个把等待时间最久的抛弃
                new ThreadPoolExecutor.DiscardPolicy());   //线程超过 8 个把再进来的线程抛弃
        try {
            for (int i = 1; i <= 10; i++) {
                final int tempI = i;
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "号窗口，服务顾客" + tempI);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
