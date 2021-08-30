package com.juc.死锁;

/**
 * @ClassName DeadLockDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 22:34
 * @Version 1.0
 **/
/*
死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种相互等待的现象，若无外力干涉那他们将无法推进下去(吃着碗里的看着锅里的)
1、系统资源不足
2、进程运行推进的顺序不合适
3、资源分配不当

解决方法：
1、银行家算法
2、强制掠夺资源
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new HoldLockThread("lockA", "lockB"), "thread1").start();
        new Thread(new HoldLockThread("lockB", "lockA"), "thread2").start();

    }
}

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockA + "\t 尝试获得：" + lockB);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockB + "\t 尝试获得：" + lockA);
            }
        }
    }
}
