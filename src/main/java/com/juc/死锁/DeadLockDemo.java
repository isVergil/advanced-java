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
1、安全序列
---进程可以动态的申请资源，但是系统在进行资源分配之前，必须先计算此次分配的安全性。如果计算所得是安全的，则允许分配，但如果是不安全的，则让进程等待。而所谓的安全状态就是，系统可以按照某种进程的推进顺序
---可以为每个进程分配其所需的资源，直到满足该进程对资源的最大需求，使得每个进程都可以顺序完成。此时p 1 , p 2 . . . p n 就是一个安全序列，但如果系统找不到这样一组安全序列，则该系统就处于不安全状态。
---安全序列可能有多个

2、银行家算法
---如果系统处于安全状态，就一定不会发生死锁
---如果系统处于不安全状态，就可能发生死锁
---Dijkstra 为银行设计的，以确保银行在发放现金贷款时，不会发生不能满足所有客户需求的情况
---进程 / 最大需求 / 已分配 / 最多还需要分配的资源数 / （资源总数，剩余可用资源）
---根据剩余可用资源 分配给还需要分配的资源数 然后该资源完成，回收资源 进行下一步的查找 直到进程执行完毕
---这样就找到了一个安全的进程执行序列，即安全序列
---https://www.bilibili.com/video/BV1kb41147CT/?spm_id_from=333.788.recommend_more_video.-1



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
