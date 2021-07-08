package com.javabasic._day07_异常线程的创建方式线程安全线程同步.多线程;

/**
 * @ClassName ThreadDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 19:43
 * @Version 1.0
 * 目标：线程的创建方式二。
 * ===
 * 多线程是很有用的，我们在进程中创建线程的方式有三种:
 * （1）直接定义一个类继承线程类Thread，重写run()方法，创建线程对象
 * 调用线程对象的start()方法启动线程。
 * （2）定义一个线程任务类实现Runnable接口，重写run()方法，创建线程任务对象，把
 * 线程任务对象包装成线程对象， 调用线程对象的start()方法启动线程。
 * （3）实现Callable接口（拓展）。
 * ===
 * b.实现Runnable接口的方式。
 * -- 1.创建一个线程任务类实现Runnable接口。
 * -- 2.重写run()方法
 * -- 3.创建一个线程任务对象。
 * -- 4.把线程任务对象包装成线程对象
 * -- 5.调用线程对象的start()方法启动线程。
 * Thread的构造器：
 * -- public Thread(){}
 * -- public Thread(String name){}
 * -- public Thread(Runnable target){}
 * -- public Thread(Runnable target,String name){}
 * 实现Runnable接口创建线程的优缺点：
 * 缺点：代码复杂一点。
 * 优点：
 * -- 线程任务类只是实现了Runnable接口，可以继续继承其他类，而且可以继续实现其他接口（避免了单继承的局限性）
 * -- 同一个线程任务对象可以被包装成多个线程对象
 * -- 适合多个多个线程去共享同一个资源
 * -- 实现解耦操作，线程任务代码可以被多个线程共享，线程任务代码和线程独立。
 * -- 线程池可以放入实现Runable或Callable线程任务对象。
 * 注意：其实Thread类本身也是实现了Runnable接口的。
 * -- 不能直接得到线程执行的结果！
 **/
public class ThreadDemo2 {
    public static void main(String[] args) {
        //创建线程任务对象
        Runnable target = new MyRunnable();
        Thread t1 = new Thread(target, "t1");
        t1.start();

        //简化写法
        Runnable t2n=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t:" + i);
                }
            }
        };
        Thread t2 = new Thread(target, "t2");
        t2.start();

        //再简化 匿名对象
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t:" + i);
                }
            }
        },"t3").start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t:" + i);
        }
    }
}

//线程任务类 实现 Runnable 接口
class MyRunnable implements Runnable {

    //重写 run() 方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "\t:" + i);
        }
    }
}
