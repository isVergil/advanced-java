package com.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/25 14:47
 * @Version 1.0
 **/
public class VolatileDemo {
    public static void main(String[] args) {
        //seeOkByVolatile();
        atomicByVolatile();
    }


    //原子性 :不可分割，完整性，也就是说某个线程正在做某个具体业务时，中间不可以被加塞或者被分割，需要具体完成，要么同时成功，要么同时失败。
    private static void atomicByVolatile() {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtmic();
                }
            }, String.valueOf(i)).start();
        }

        //等待以上20个线程完成
        //主线程 +  gc 线程
        while (Thread.activeCount() > 2) {
            //让出线程
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "finally number value:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "finally number value:" + myData.atomicInteger);
    }


    //volatile 可见性
    //问题：while 循环中加上 println 或者 Thread.sleep 会导致可见性
    //1、像这种一直while循环，cpu一直占用，就没有机会刷新工作内存
    //2、如果加sleep或其他让该线程阻塞，然后获取cpu，cpu得到切换就可以有机会刷新工作内存
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update" + myData.number);
        }, "AAA").start();

        while (myData.number == 0) {
            System.out.println("---");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t");
    }
}

class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    //加了 volatile 不保证原子性
    public void addPlusPlus() {
        ++number;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtmic() {
        //atomicInteger++;
        atomicInteger.getAndIncrement();
    }


}
