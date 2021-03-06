package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池;

/**
 * @ClassName VolatileAtomicThreadDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/10 15:46
 * @Version 1.0
 **/

import java.util.concurrent.atomic.AtomicInteger;

/***
 * 目标：原子性。
 *
 *     概述：所谓的原子性是指在一次操作或者多次操作中， 要么同时成功，要么同时失败，不能被干扰
 *          所有的操作全部都得到了执行并且不会受到任何因素的干扰。最终结果要保证线程安全。
 *
 *     小结：在多线程环境下，volatile关键字可以保证共享数据的可见性，
 *          但是并不能保证对数据操作的原子性（在多线程环境下volatile修饰的变量也是线程不安全的）。
 *          volatile的使用场景
 *              - 开关控制
 *              利用可见性特点，控制某一段代码执行或者关闭(比如今天课程的第一个案例)。
 *              - 多个线程操作共享变量，但是是有一个线程对其进行写操作，其他的线程都是读。此时加上更好，其他线程可以立即读取到最新值。
 *          volatile不能保证变量操作的原子性（安全性）。
 *
 * ---------如何保证变量访问的原子性呢?----------------
 *    1.加锁实现线程安全。（加锁线程性能比较差）
 *         synchronized关键字
 *    2.基于CAS方式的原子类。
 *             -- Java已经提供了一些本身即可实现原子性（线程安全）的类。
 *             -- 概述：java从JDK1.5开始提供了java.util.concurrent.atomic包(简称Atomic包)，
 *                     这个包中的原子操作类提供了一种用法简单
 *                     ，性能高效，线程安全地更新一个变量的方式。
 *             -- 操作整型的原子类
 *                  public AtomicInteger()：	   				初始化一个默认值为0的原子型Integer
 *                  public AtomicInteger(int initialValue)： 初始化一个指定值的原子型Integer
 *                  int get():   			 				 获取值
 *                  int getAndIncrement():      			 以原子方式将当前值加1，注意，这里返回的是自增前的值。
 *                  int incrementAndGet():     			 以原子方式将当前值加1，注意，这里返回的是自增后的值。
 *                  int addAndGet(int data):				 以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
 *                  int getAndSet(int value):   			 以原子方式设置为newValue的值，并返回旧值。
 *
 *      CAS与Synchronized总结：
 *      CAS和Synchronized都可以保证多线程环境下共享数据的安全性。那么他们两者有什么区别？
 *      Synchronized是从悲观的角度出发：
 *          总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁
 *          （**共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程**）。因此Synchronized我们也将其称之为**悲观锁**。jdk中的ReentrantLock也是一种悲观锁。性能较差！！
 *      CAS是从乐观的角度出发:
 *          总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据。
 *          CAS这种机制我们也可以将其称之为乐观锁。综合性能较好！
 */
public class VolatileAtomicThreadDemo {
    public static void main(String[] args) {
        //Runnable target = new MyRunnableTest();
        Runnable target = new MyRunnableAtomic();
        for (int i = 1; i <= 100; i++) {
            //启用100个线程，执行100次任务
            new Thread(target).start();
        }
    }
}

//原子类
class MyRunnableAtomic implements Runnable {
    // 原子类中封装好了整型变量，默认值是0
    private AtomicInteger atomicInteger = new AtomicInteger();

    //一次任务+100
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "count ===>" + atomicInteger.incrementAndGet());
        }

    }
}


//加锁
class MyRunnableTest implements Runnable {
    private int count;

    //一次任务+100
    @Override
    public synchronized void run() {
        for (int i = 1; i <= 100; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + "count ===>" + count);
        }

    }
}
