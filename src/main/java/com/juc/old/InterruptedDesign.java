package com.juc.old;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName InterruptedDesign
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 22:12
 * @Version 1.0
 * <p>
 * 两阶段终止模式 TwoPhaseTermination
 * 1、InterruptedException异常的抛出并不是意味着线程必须得终止，它只是提醒当前线程有中断操作发生了 使isInterrupted=false
 * 2、抛出异常是在while循环之内 故线程发生异常时线程不会终止
 **/
@Slf4j(topic = "c.InterruptedDesign")
public class InterruptedDesign {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();
        Thread.sleep(3500);
        twoPhaseTermination.stop();
    }

}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {
    private Thread monitor;

    //启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);  //情况1  sleep 中被打断进入异常体
                    //执行监控操作
                    log.debug("执行监控记录");  //情况2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记
                    Thread.currentThread().interrupt();
                }
            }
        });
        monitor.start();
    }

    //停止监控线程
    public void stop() {
        monitor.interrupt();
    }


}
