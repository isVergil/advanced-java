package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池;

/**
 * @ClassName ThreadCommunication
 * @Description TODO
 * @Author bill
 * @Date 2021/7/9 14:14
 * @Version 1.0
 * 目标：线程通信（了解原理，代码几乎不用）
 * 线程通信：多个线程因为在同一个进程中，所以互相通信比较容易的。
 * ===
 * 线程通信的经典模型：生产者与消费者问题。
 * ---生产者负责生成商品，消费者负责消费商品。
 * ---生产不能过剩，消费不能没有。
 * ===
 * 模拟一个案例：
 * 小明和小红有一个共同账户：共享资源
 * 他们有3个爸爸（亲爸，岳父，干爹）给他们存钱。
 * ===
 * 模型：小明和小红去取钱，如果有钱就取出，然后等待自己，唤醒他们3个爸爸们来存钱
 * 他们的爸爸们来存钱，如果发现有钱就不存，没钱就存钱，然后等待自己，唤醒孩子们来取钱。
 * 做整存整取：10000元。
 * 分析：
 * 生产者线程：亲爸，岳父，干爹
 * 消费者线程：小明，小红
 * 共享资源：账户对象。
 * ===
 * 注意：线程通信一定是多个线程在操作同一个资源才需要进行通信。
 * 线程通信必须先保证线程安全，否则毫无意义，代码也会报错！
 * ===
 * 线程通信的核心方法：
 * public void wait(): 让当前线程进入到等待状态 此方法必须锁对象调用.
 * public void notify() : 唤醒当前锁对象上等待状态的某个线程  此方法必须锁对象调用
 * public void notifyAll() : 唤醒当前锁对象上等待状态的全部线程  此方法必须锁对象调用
 * 小结：
 * 是一种等待唤醒机制。
 * 必须是在同一个共享资源才需要通信，而且必须保证线程安全。
 **/
public class ThreadCommunication {
    public static void main(String[] args) {
        //1、创建共享账户
        Account account = new Account("id", 0);

        //2、创建两个线程对象代表 两人
        new DrawThread(account, "小明").start();
        new DrawThread(account, "小红").start();

        //3、创建三个个线程对象代表 三人
        new SaveThread(account, "亲爹").start();
        new SaveThread(account, "干爹").start();
        new SaveThread(account, "岳父").start();
    }
}

//取钱的线程类
class DrawThread extends Thread {
    private Account account;

    public DrawThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        //不断取钱
        while (true) {
            account.drawMoney(100);
        }

    }
}

//存钱的线程类
class SaveThread extends Thread {
    private Account account;

    public SaveThread(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        //不断存钱
        while (true) {
            //等待三秒再存钱
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.saveMoney(100);
        }
    }
}

//账户类
class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double mmoney) {
        this.cardID = cardID;
        this.money = mmoney;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //取钱 小明 小红
    public synchronized void drawMoney(double money) {
        try {
            //谁来取钱
            String name = Thread.currentThread().getName();
            if (this.money >= money) {
                this.money -= money;
                System.out.println(name + "来取钱，取走" + money + " 剩余" + this.money);
                //取钱后没钱 唤醒别人 让别的线程进来 再等待暂停自己
                this.notifyAll();
                this.wait();
            } else {
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //存钱 三个人
    public synchronized void saveMoney(double money) {
        try {
            //谁来存钱
            String name = Thread.currentThread().getName();
            if (this.money > 0) {    //余额充足 让小孩来取
                this.notifyAll();
                this.wait();
            } else {                //余额不足 存钱
                this.money += money;
                System.out.println(name + "来存钱 " + money + " 剩余" + this.money);
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
