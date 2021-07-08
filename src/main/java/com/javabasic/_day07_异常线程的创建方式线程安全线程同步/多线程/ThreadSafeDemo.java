package com.javabasic._day07_异常线程的创建方式线程安全线程同步.多线程;

/**
 * @ClassName ThreadSafeDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 21:22
 * @Version 1.0
 * 目标：线程安全问题。
 * <p>
 * 线程安全问题：多个线程同时操作同一个共享资源的时候可能会出现线程安全问题。
 * <p>
 * 模拟出取款问题的案例：
 * 注意：用高度面向对象的思想设计。
 * 分析：
 * （1）提供一个账户类Account.java作为创建共享资源账户对象的类。
 * （2）定义一个线程类来用于创建2个线程分别代表小明和小红来取钱。
 * 小结：
 * 多个线程同时操作同一个共享资源的时候可能会出现线程安全问题。
 **/
public class ThreadSafeDemo {
    public static void main(String[] args) {
        Account acc = new Account("1", 100);
        Thread t1 = new DrawThread(acc, "小明");
        Thread t2 = new DrawThread(acc, "小红");
        t1.start();
        t2.start();
    }
}

// 线程类：创建取钱线程对象的。
class DrawThread extends Thread {
    // 定义一个成员变量接收账户对象
    private Account acc;

    public DrawThread(Account acc, String name) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        // 小明 小红
        // 取钱100000
        acc.drawMoney(100);
    }
}

// 账户类
class Account {
    private String cardID;
    private double moeny;

    // 小明线程/小红线程
    public void drawMoney(double moeny) {
        // 开始判断取钱逻辑
        // 1.先知道是谁来取钱
        String name = Thread.currentThread().getName();
        // 2.判断余额是否足够
        if (this.moeny >= moeny) {
            System.out.println(name + "来取钱，余额足够，吐出" + moeny);
            // 3.更新余额
            this.moeny -= moeny;
            System.out.println(name + "来取钱后，余额剩余" + this.moeny);
        } else {
            System.out.println(name + "来取钱，余额不足！");
        }
    }

    public Account() {
    }

    public Account(String cardID, double moeny) {
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