package com.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Lock8Demo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/23 23:53
 * @Version 1.0
 **/

@Slf4j(topic = "c.Lock8Demo")
public class Lock8Demo {
    public static void main(String[] args) {
//        Number n1 = new Number();
//        new Thread(() -> {
//            try {
//                log.debug("Thread1");
//                n1.a();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            log.debug("Thread2");
//            n1.b();
//        }).start();
//        new Thread(() -> {
//            log.debug("Thread3");
//            n1.c();
//        }).start();

        //锁的两个不同的对象 没有互斥，没有关系
        Number n3 = new Number();
        Number n4 = new Number();
        new Thread(() -> {
            log.debug("Thread3");
            try {
                n3.a();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            log.debug("Thread4");
            n4.b();
        }).start();
    }
}

@Slf4j(topic = "c.Number")
class Number {
    //对象的锁标记是存储在对象头当中的，而这两个线程的run都是调用的同一个对象的方法。
    //加在非静态方法上，也就是给实例对象加锁；加在静态方法上，是给类加锁；Sychronized(指定对象)给指定对象加锁
    public synchronized void a() throws InterruptedException {
        Thread.sleep(1000);   //sleep不会释放锁
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }

    public void c() {
        log.debug("3");
    }
}

@Slf4j(topic = "c.Number1")
class Number1 {
    //对象的锁标记是存储在对象头当中的，而这两个线程的run都是调用的同一个对象的方法。
    //加在非静态方法上，也就是给实例对象加锁；加在静态方法上，是给类加锁；Sychronized(指定对象)给指定对象加锁
    public static synchronized void a() throws InterruptedException {
        Thread.sleep(1000);   //sleep不会释放锁
        log.debug("1");
    }

    public synchronized void b() {
        log.debug("2");
    }

    //两把锁

}

@Slf4j(topic = "c.Number2")
class Number2 {
    //对象的锁标记是存储在对象头当中的，而这两个线程的run都是调用的同一个对象的方法。
    //加在非静态方法上，也就是给实例对象加锁；加在静态方法上，是给类加锁；Sychronized(指定对象)给指定对象加锁
    public static synchronized void a() throws InterruptedException {
        Thread.sleep(1000);   //sleep不会释放锁
        log.debug("1");
    }

    public static synchronized void b() {
        log.debug("2");
    }

    //一把锁锁住类对象，类对象只有一个

}

