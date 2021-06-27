package com.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadMethod
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 18:21
 * @Version 1.0
 * <p>
 * 调用 sleep 会让当前线程从 Running 进入 TimedWaiting 状态（阻塞）
 * 调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程
 * sleep yield 比较
 * yield 就绪状态 可能会被任务调度器分时间片然后调度
 * sleep 阻塞状态 任务调度器不会分配时间片
 * <p>
 * 线程优先级会提示（hint）调度器优先调度该线程，但它仅仅是一个提示，调度器可以忽略它
 * 如果 cpu 比较忙，那么优先级高的线程会获得更多的时间片，但 cpu 闲时，优先级几乎没作用
 * <p>
 * join方法  : 等待调用join的线程结束
 * join(long n); 有时效的 join --- 最多等待n毫秒 不管其他线程有没有完成
 * <p>
 * interrupt 方法 ：
 * 打断 sleep，wait，join 的线程, 会清空打断状态 即  isInterrupted()==false
 * 打断 正常运行的线程, 不会清空打断状态
 **/
@Slf4j(topic = "c.ThreadMethod")
public class ThreadMethod {

    static int r = 0;
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws Exception {
        //runAndStart();
        //sleepTest();
        //interruptTest();
        //yieldTest();
        //joinTest();
        //joinTest2();
        //interruptTest2();
        interruptTest3();
    }

    private static void runAndStart() {
        Thread t1 = new Thread(() -> log.debug("running..."), "t1");
        System.out.println(t1.getState());   //NEW
        System.out.println("t1.start()");
        t1.start();    //[t1] c.ThreadMethod - running...
        System.out.println(t1.getState());   //RUNNABLE

        System.out.println("--------------------");
        Thread t2 = new Thread(() -> log.debug("running..."), "t2");
        System.out.println(t2.getState());   //NEW
        System.out.println("t2.run()");
        t2.run();      //[main] c.ThreadMethod - running...
        System.out.println(t2.getState());   //NEW
    }

    private static void sleepTest() {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        log.debug("t1 state: {}", t1.getState());   //t1 state: RUNNABLE   主线程先运行 打印 RUNNABLE
        try {
            Thread.sleep(500);         //主线程休眠 让出cpu让 t1 运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("t1 state: {}", t1.getState());  //t1 state: TIMED_WAITING    t1 运行 sleep 此时t1的状态就是  TIMED_WAITING

    }

    private static void interruptTest() {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("enter sleep...");
                try {
                    //Thread.sleep(2000);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    log.debug("wake up...");
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        try {
            //Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("interrupt...");
        t1.interrupt();
    }

    private static void yieldTest() {
        Thread t1 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println("    ------>t1" + count++);
            }
        });
        Thread t2 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                //Thread.yield();
                System.out.println("------>t2" + count++);
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }

    private static void joinTest() throws Exception {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        });
        t1.start();
        //等待t1结束
        t1.join();
        log.debug("结果为:{}", r);
        log.debug("结束");
    }

    private static void joinTest2() throws Exception {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                r2 = 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        log.debug("join begin");
        t1.join();
        log.debug("t1 join end");
        t2.join();
        log.debug("t2 join end");
        long end = System.currentTimeMillis();
        log.debug("r1 : {} r2 : {} cost : {} ", r1, r2, end - start);
    }

    private static void interruptTest2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("sleep...");
            try {
                //Thread.sleep(5000);
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
        Thread.sleep(1000);
        log.debug("打断标记{}", t1.isInterrupted());
    }

    private static void interruptTest3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    log.debug("被打断了，退出循环");
                    break;
                }
            }
        });
        t1.start();
        log.debug("打断标记{}", t1.isInterrupted());
        Thread.sleep(1000);
        log.debug("interrupt");
        t1.interrupt();
        Thread.sleep(1000);
        log.debug("打断标记{}", t1.isInterrupted());
    }
}
