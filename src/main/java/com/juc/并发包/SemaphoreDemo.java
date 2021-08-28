package com.juc.并发包;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/27 16:17
 * @Version 1.0
 **/
/*
 抢车位 互斥操作争抢资源
信号量主要用于两个目的
• 一个是用于共享资源的互斥使用
• 另一个用于并发线程数的控制
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 3 个车位
        Semaphore semaphore = new Semaphore(3);
        // 6 个车子来停车
        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                try {
                    //来停车
                    semaphore.acquire();
                    System.out.println("车辆" + Thread.currentThread().getName() + "：抢到车位");
                    //停三秒
                    Thread.sleep(3000);
                    System.out.println("车辆" + Thread.currentThread().getName() + "：离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //放出车位
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
