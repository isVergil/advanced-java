package com.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName InterruptParkDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 15:41
 * @Version 1.0
 **/
@Slf4j(topic = "c.InterruptParkDemo")
public class InterruptParkDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
            //log.debug("打断状态：{}", Thread.currentThread().isInterrupted());   //true
            log.debug("打断状态：{}", Thread.interrupted());    //返回true  修改打断标记为flase
            LockSupport.park();
            log.debug("park...");

        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        while(true){
            System.out.println("主线程打印");
        }

    }
}
