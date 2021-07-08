package com.javabasic._day07_异常线程的创建方式线程安全线程同步.多线程;

/**
 * @ClassName ThreadSynchronizedDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 21:36
 * @Version 1.0
 * 目标：线程同步_同步代码块  性能：锁大（坏）锁小（好）的问题 (蹲坑锁门还是锁坑)
 * ===
 * 线程同步的作用：就是为了解决线程安全问题的方案。
 * ===
 * 线程同步解决线程安全问题的核心思想：
 * 让多个线程实现先后依次访问共享资源，这样就解决了安全问题。
 * ===
 * 线程同步的做法：加锁
 * 是把共享资源进行上锁，每次只能一个线程进入访问完毕以后，其他线程才能进来。
 * ===
 * 线程同步的方式有三种：
 * （1）同步代码块。
 * （2）同步方法。
 * （3）lock显示锁。
 * ===
 * a.同步代码块。
 * 作用：把出现线程安全问题的核心代码给上锁，每次只能一个线程进入
 * 执行完毕以后自动解锁，其他线程才可以进来执行。
 * ===
 * 格式：
 * synchronized(锁对象){
 * // 访问共享资源的核心代码
 * }
 * 锁对象：理论上可以是任意的“唯一”对象即可。
 * 原则上：锁对象建议使用共享资源。
 * -- 在实例方法中建议用this作为锁对象。此时this正好是共享资源！必须代码高度面向对象
 * -- 在静态方法中建议用类名.class字节码作为锁对象。
 * ===
 * b.同步方法
 * 作用：把出现线程安全问题的核心方法给锁起来，
 * 每次只能一个线程进入访问，其他线程必须在方法外面等待。
 * 用法：直接给方法加上一个修饰符 synchronized.
 * 原理:  同步方法的原理和同步代码块的底层原理其实是完全一样的，只是
 * 同步方法是把整个方法的代码都锁起来的。
 * 同步方法其实底层也是有锁对象的：
 * 如果方法是实例方法：同步方法默认用this作为的锁对象。
 * 如果方法是静态方法：同步方法默认用类名.class作为的锁对象。
 **/
public class ThreadSynchronizedDemo {
    public static void main(String[] args) {
        AccountLock acc = new AccountLock("1", 100);
        Thread t1 = new DrawThreadSafe(acc, "小明");
        Thread t2 = new DrawThreadSafe(acc, "小红");
        t1.start();
        t2.start();
    }
}

// 线程类：创建取钱线程对象的。
class DrawThreadSafe extends Thread {
    // 定义一个成员变量接收账户对象
    private AccountLock acc;

    public DrawThreadSafe(AccountLock acc, String name) {
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
class AccountSafe {
    private String cardID;
    private double moeny;

    // 小明线程/小红线程
    public void drawMoneySafe(double moeny) {
        // 开始判断取钱逻辑
        // 1.先知道是谁来取钱
        String name = Thread.currentThread().getName();
        // 2.判断余额是否足够
        //锁当前对象🔒
        synchronized (this) {
            if (this.moeny >= moeny) {
                System.out.println(name + "来取钱，余额足够，吐出" + moeny);
                // 3.更新余额
                this.moeny -= moeny;
                System.out.println(name + "来取钱后，余额剩余" + this.moeny);
            } else {
                System.out.println(name + "来取钱，余额不足！");
            }
        }

    }

    public AccountSafe() {
    }

    public AccountSafe(String cardID, double moeny) {
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
