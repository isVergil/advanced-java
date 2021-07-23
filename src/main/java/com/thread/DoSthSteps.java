package com.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName DoSthSteps
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 16:49
 * @Version 1.0
 **/
@Slf4j(topic = "c.DoSthSteps")
public class DoSthSteps {
    public static void main(String[] args) throws Exception {
        //该线程先洗水壶1分钟 再烧水15分钟
        Thread li = new Thread(() -> {
            log.debug("洗水壶1分钟");
            log.debug("烧水15分钟");
        }, "小李");

        //该线程洗茶壶,洗茶杯,拿茶叶 4分钟
        Thread zeng = new Thread(() -> {
            log.debug("洗茶壶");
            log.debug("洗茶杯");
            log.debug("拿茶叶");
            try {
                li.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("泡茶");
        }, "小曾");

        li.start();
        zeng.start();

    }
}
