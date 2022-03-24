package com.juc.其他补充;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CreateThreadPool
 * @Description 线程池创建线程的方法
 * @Author bill
 * @Date 2022/2/25 0:57
 * @Version 1.0
 **/
public class CreateThreadPool {

    //源码中 也是创建 defaultThreadFactory() 来创建线程
    //defaultThreadFactory()  里是 new Thread(); 来的
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Task1() {
            });
        }
    }

}

class Task1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}


