package com.juc.lock;

import java.util.concurrent.atomic.AtomicReference;

/*
自旋锁：spinlock，是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去
尝试获取锁，这样的好处是减少线程上下文切换的消耗，缺点是循环会消耗CPU
原来提到的比较并交换，底层使用的就是自旋，自旋就是多次尝试，多次访问，不
会阻塞的状态就是自旋。
优点：循环比较获取直到成功为止，没有类似于wait 的阻塞
缺点：当不断自旋的线程越来越多的时候，会因为执行 while 循环不断的消耗CPU资源

手写自旋锁
通过CAS 操作完成自旋锁，A 线程先进来调用myLock 方法自己持有锁5 秒，B
随后进来发现当前有线程持有锁，不是null，所以只能通过自旋等待，直到A 释
放锁后B 随后抢到
 */
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t myUnLock");


    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                //sleep没有让出锁
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        }, "AA").start();

//        try {
//            //sleep没有让出锁
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                //sleep没有让出锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();
        }, "BB").start();
    }
}
