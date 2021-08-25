package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SleepYieldDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/21 22:59
 * @Version 1.0
 **/
@Slf4j(topic = "c.SleepYieldDemo")
public class SleepYieldDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread("t1") {
            @Override
            public void run() {
                try {
                    log.debug("sleepping...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.debug("wake...");
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //log.debug("{}", t.getState());  //RUNNABLE
        TimeUnit.SECONDS.sleep(1);
        //log.debug("{}", t.getState());  //TIMED_WAITING
        t.interrupt();   //打断
        log.debug("{}", t.getState());
    }
}
