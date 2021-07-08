package com.javabasic._day07_异常线程的创建方式线程安全线程同步.多线程;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 18:59
 * @Version 1.0
 * 目标：多线程的概述。（并发编程）
 * ==============
 * 什么是进程？
 * 程序是静止的，运行中的程序就是进程。
 * 进程的三个特征：
 * 1.动态性 ： 进程是运行中的程序，要动态的占用内存，CPU和网络等资源。
 * 2.独立性 ： 进程与进程之间是相互独立的，彼此有自己的独立内存区域。
 * 3.并发性 ： 假如CPU是单核，同一个时刻其实内存中只有一个进程在被执行。
 * CPU会分时轮询切换依次为每个进程服务，因为切换的速度非常
 * 快，给我们的感觉这些进程在同时执行，这就是并发性。
 * ==============
 * 并行:同一个时刻同时有多个在执行。
 * ==============
 * 什么是线程？
 * 线程是属于进程的。一个进程可以包含多个线程，这就是多线程。
 * 线程是进程中的一个独立执行单元。
 * 线程创建开销相对于进程来说比较小。
 * 线程也支持“并发性”。
 * ==============
 * 线程的作用：
 * 可以提高程序的效率，线程也支持并发性，可以有更多机会得到CPU。
 * 多线程可以解决很多业务模型。
 * 大型高并发技术的核心技术。
 * 设计到多线程的开发可能都比较难理解。
 * ================
 * ================
 * 多线程是很有用的，我们在进程中创建线程的方式有三种:
 * （1）直接定义一个类继承线程类Thread，重写run()方法，创建线程对象
 * 调用线程对象的start()方法启动线程。
 * （2）定义一个线程任务类实现Runnable接口，重写run()方法，创建线程任务对象，把
 * 线程任务对象包装成线程对象， 调用线程对象的start()方法启动线程。
 * （3）实现Callable接口（拓展）。
 * a.继承Thread类的方式
 * -- 1.定义一个线程类继承Thread类。
 * -- 2.重写run()方法
 * -- 3.创建一个新的线程对象。
 * -- 4.调用线程对象的start()方法启动线程。
 * 继承Thread类的优缺点：
 * 优点：编码简单。
 * 缺点：线程类已经继承了Thread类无法继承其他类了，功能不能通过继承拓展（单继承的局限性）
 * 小结：
 * 线程类是继承了Thread的类。
 * 启动线程必须调用start()方法。
 * 多线程是并发抢占CPU执行，所以在执行的过程中会出现并发随机性。
 * =======
 * 1.线程的启动必须调用start()方法。否则当成普通类处理。
 * -- 如果线程直接调用run()方法，相当于变成了普通类的执行，此时将只有主线程在执行他们！
 * -- start()方法底层其实是给CPU注册当前线程，并且触发run()方法执行
 * 2.建议线程先创建子线程，主线程的任务放在之后。否则主线程永远是先执行完！
 * =====
 * =====
 * public static void sleep(long time): 让当前线程休眠多少毫秒再继续执行。
 **/
public class ThreadDemo {
    //进程
    //main主线程
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");
        //t1.setName("t1");
        t1.start();
        Thread t2 = new MyThread("t2");
        //t2.setName("t2");
        t2.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "\t:" + i);
        }

    }
}

//线程类
class MyThread extends Thread {
    public MyThread(String name) {
        // 调用父类的有参数构造器初始化当前线程对象的名称！
        super(name);
    }

    @Override
    public void run() {
        //线程的执行方法
        for (int i = 0; i < 5; i++) {
            System.out.println(currentThread().getName() + "\t:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
