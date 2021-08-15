package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池.并发包;

/**
 * @ClassName CyclicBarrierDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/10 21:34
 * @Version 1.0
 **/

import java.util.concurrent.CyclicBarrier;

/***
 *    目标：
 *
 *     CyclicBarrier作用：
 *         某个线程任务必须等待其他线程执行完毕以后才能最终触发自己执行。
 *     例如：公司召集5名员工开会，等5名员工都到了，会议开始。
 *         我们创建5个员工线程，1个开会任务，几乎同时启动
 *         使用CyclicBarrier保证5名员工线程全部执行后，再执行开会线程。
 *     构造器：
 *          public CyclicBarrier(int parties, Runnable barrierAction)
 *          // 用于在线程到达屏障5时，优先执行barrierAction，方便处理更复杂的业务场景
 *     方法：
 *          public int await()
 *          // 每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞
 *     小结：
 *         可以实现多线程中，某个任务在等待其他线程执行完毕以后触发。
 *         循环屏障可以实现达到一组屏障就触发一个任务执行！
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Meeting());
        for (int i = 0; i < 5; i++) {
            new EmployeeThread("员工" + i, cyclicBarrier).start();
        }
    }
}

class Meeting implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始组织会议");
    }
}

class EmployeeThread extends Thread {
    private CyclicBarrier cb;

    public EmployeeThread(String name, CyclicBarrier cb) {
        super(name);
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("员工：" + Thread.currentThread().getName() + "进入会议室");
            cb.await(); // 自己做完了，告诉循环屏障我结束了！
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}