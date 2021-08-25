package com.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName DaemonDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 16:12
 * @Version 1.0
 **/
@Slf4j(topic = "c.DaemonDemo")
public class DaemonDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
            log.debug("t1 结束");
        }, "t1");
        thread.setDaemon(true);
        thread.start();
        log.debug("main 结束");
    }
}
