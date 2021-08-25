package com.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName InterruptDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 14:34
 * @Version 1.0
 **/
@Slf4j(topic = "c.InterruptDemo")
public class InterruptDemo {
    public static void main(String[] args) throws Exception {
        //打断阻塞状态的线程
//        Thread t1 = new Thread(() -> {
//            log.debug("{}", Thread.currentThread().isInterrupted());
//            log.debug("sleep...");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "t1");
//        t1.start();
//        Thread.sleep(1000);
//        log.debug("interrupt...");
//        t1.interrupt();
//        log.debug("打断标记{}", t1.isInterrupted()); //false

        //打断正常运行状态的线程
        Thread t2 = new Thread(() -> {
            while (true) {
//                try {
//                    Thread.sleep(5);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();e.printStackTrace();
//                }

                if (Thread.currentThread().isInterrupted()) {
                    log.debug("t2 被打断了");
                    //break;
                } else {
                    log.debug("t2 is running...");
                }
            }
        }, "t2");
        t2.start();
        log.debug("interrupt...");
        t2.interrupt();
        log.debug("打断标记{}", t2.isInterrupted());
    }
}
