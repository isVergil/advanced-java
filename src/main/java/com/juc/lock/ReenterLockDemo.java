package com.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
可重入锁就是递归锁
指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取到该锁的代码，在
同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
也就是说：线程可以进入任何一个它已经拥有的锁所同步的代码块
ReentrantLock / Synchronized 就是一个典型的可重入锁
最大作用就是避免死锁
 */
public class ReenterLockDemo {

    public static void main(String[] args) {
        //synchronizedTest();
        ReentrantLockTest();

    }

    private static void ReentrantLockTest() {
        Car car = new Car();
        Thread t3 = new Thread(car);
        Thread t4 = new Thread(car);
        t3.start();
        t4.start();
    }

    private static void synchronizedTest() {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();

        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();
    }
}

//Synchronized 是可重入锁的代码验证
class Phone {
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "\t  发短信");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "\t  发邮件");
    }
}

//ReentrantLock 是可重入锁的代码证
class Car implements Runnable {

    //默认非公平锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    public void get() {
        //上锁几次都一样 但是要两两配对
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t  get()");
            set();
        } finally {
            //解锁几次都可以
            // lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t  set()");
        } finally {
            lock.unlock();
        }
    }
}
