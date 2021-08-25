package com.juc.old;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName RunThread
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 14:46
 * @Version 1.0
 **/
@Slf4j(topic = "c.RunThread")
public class RunThread {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                log.debug("running");
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                log.debug("running");
            }
        }, "t2").start();
    }
}
