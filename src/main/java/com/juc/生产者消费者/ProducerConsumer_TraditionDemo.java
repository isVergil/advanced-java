package com.juc.生产者消费者;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ProducerConsumer_TraditionDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/28 16:43
 * @Version 1.0
 **/
/*
一个初始值为0 的变量，两个线程对其交替操作，一个加1，一个减1，来5 轮
1、线程操作资源类
2、判断干活唤醒通知
3、防止多线程下的虚假唤醒  while
 */
public class ProducerConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}

//资源类
class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产
    public void increment() throws Exception {
        lock.lock();
        try {
            //1、判断 number != 0 则不能生产，等待消费
            while (number != 0) {
                //等待不能生产
                condition.await();
            }
            //2、干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            //3、通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费
    public void decrement() throws Exception {
        lock.lock();
        try {
            //1、判断 number == 0 则不能消费，等待生产
            while (number == 0) {
                //等待不能生产
                condition.await();
            }
            //2、干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t " + number);
            //3、通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}