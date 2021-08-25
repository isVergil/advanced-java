package com.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TwoPhaseTerminationDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/22 15:25
 * @Version 1.0
 **/
@Slf4j(topic = "c.TwoPhaseTerminationDemo")
public class TwoPhaseTerminationDemo {
    public static void main(String[] args) throws Exception {
        TwoPhaseTermination monitorThread = new TwoPhaseTermination();
        monitorThread.Start();
        Thread.sleep(2000);
        monitorThread.stop();
    }
}

@Slf4j(topic = "c.TwoPhaseTermination")
class TwoPhaseTermination {
    private Thread monitor;

    //启动监控线程
    public void Start() {
        monitor = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug("被打断了 do something...");
                    break;
                }
                try {
                    Thread.sleep(1000);                     //1、在这里被打断（睡眠中打断）
                    log.debug("执行监控记录 do something...");     //2、在这里被打断（继续循环发现打断  do something）
                } catch (InterruptedException e) {
                    //此时 打断标记变成 false 此时需要手动将打断标记置为 true
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }, "monitor");
        monitor.start();
    }

    //停止监控线程
    public void stop() {
        monitor.interrupt();
    }
}
