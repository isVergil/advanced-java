package com.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SyncAndReenteantLockDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/28 19:08
 * @Version 1.0
 **/
/*
锁绑定多个条件Condition
• synchronized：没有，要么随机，要么全部唤醒
• ReentrantLock：用来实现分组唤醒需要唤醒的线程，可以精确唤醒，而不是像synchronized 那样，要么随机，要么全部唤醒

题目：多线程之间按顺序调用，实现 A-> B -> C 三个线程启动，要求如下：
AA 打印5 次，BB 打印10 次，CC 打印15 次
紧接着
AA 打印5 次，BB 打印10 次，CC 打印15 次
..
来10 轮
 */
public class SyncAndReenteantLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        }, "CC").start();
    }

}

class ShareResource {

    private int number = 1;    //A:1 B:2 C:3

    private Lock lock = new ReentrantLock();

    private Condition AA = lock.newCondition();
    private Condition BB = lock.newCondition();
    private Condition CC = lock.newCondition();

    //AA 打印5次
    public void print5() {
        lock.lock();
        try {
            //1、判断 number != 1 A 线程等待
            while (number != 1) {
                //A 线程等待
                AA.await();
            }
            //2、干活 A线程打印 5 次
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //修改标志位
            number = 2;
            //3、通知唤醒  只通知 B 来工作
            BB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //BB 打印10次
    public void print10() {
        lock.lock();
        try {
            //1、判断 number != 2 B 线程等待
            while (number != 2) {
                //B 线程等待
                BB.await();
            }
            //2、干活 B线程打印 10 次
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //修改标志位
            number = 3;
            //3、通知唤醒  只通知 C 来工作
            CC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //CC 打印15次
    public void print15() {
        lock.lock();
        try {
            //1、判断 number != 3 C 线程等待
            while (number != 3) {
                //A 线程等待
                CC.await();
            }
            //2、干活 C线程打印 15 次
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t " + i);
            }
            //修改标志位
            number = 1;
            //3、通知唤醒  只通知 A 来工作
            AA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
