package com.javabasic._day07_异常线程的创建方式线程安全线程同步.多线程;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName LockDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 21:49
 * @Version 1.0
 * 目标：线程同步_同步代码块
 * ===
 * 线程同步的作用：就是为了解决线程安全问题的方案。
 * ===
 * 线程同步解决线程安全问题的核心思想：
 * 让多个线程实现先后依次访问共享资源，这样就解决了安全问题。
 * 线程同步的做法：
 * 是把共享资源进行上锁，每次只能一个线程进入访问完毕以后，其他线程才能进来。
 * ====
 * 线程同步的方式有三种：
 * （1）同步代码块。
 * （2）同步方法。
 * （3）lock显示锁。
 * ====
 * c.lock显示锁。
 * java.util.concurrent.locks.Lock机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
 * 同步代码块/同步方法具有的功能Lock都有,除此之外更强大
 * ====
 * Lock锁也称同步锁，加锁与释放锁方法化了，如下：
 * - `public void lock() `:加同步锁。
 * - `public void unlock()`:释放同步锁。
 * ====
 * 总结：
 * 线程安全，性能差。
 * 线程不安全性能好。假如开发中不会存在多线程安全问题，建议使用线程不安全的设计类。
 **/
public class LockDemo {
    public static void main(String[] args) {
        // a.创建一个账户对象。
        AccountLock acc = new AccountLock("123", 100);
        // b.定义一个线程类创建2个线程代表小明和小红
        Thread xiaoMing = new DrawThreadLock(acc, "小明");
        xiaoMing.start();

        Thread xiaoRed = new DrawThreadLock(acc, "小红");
        xiaoRed.start();
    }
}

// 线程类：创建取钱线程对象的。
class DrawThreadLock extends Thread {
    // 定义一个成员变量接收账户对象
    private AccountLock acc;

    public DrawThreadLock(AccountLock acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        // 小明 小红
        // 取钱100000
        acc.drawMoneySafe(100);
    }
}


// 账户类
class AccountLock {
    private String cardID;
    private double moeny;

    //创建一把锁
    private final Lock lock = new ReentrantLock();

    // 小明线程/小红线程
    public void drawMoneySafe(double moeny) {
        // 开始判断取钱逻辑
        // 1.先知道是谁来取钱
        String name = Thread.currentThread().getName();
        // 2.判断余额是否足够
        // 上锁
        lock.lock();
        try {
            if (this.moeny >= moeny) {
                System.out.println(name + "来取钱，余额足够，吐出" + moeny);
                // 3.更新余额
                this.moeny -= moeny;
                System.out.println(name + "来取钱后，余额剩余" + this.moeny);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public AccountLock() {
    }

    public AccountLock(String cardID, double moeny) {
        this.cardID = cardID;
        this.moeny = moeny;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoeny() {
        return moeny;
    }

    public void setMoeny(double moeny) {
        this.moeny = moeny;
    }
}