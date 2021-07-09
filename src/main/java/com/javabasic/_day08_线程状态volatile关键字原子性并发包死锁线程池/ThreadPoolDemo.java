package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池;

import java.util.concurrent.*;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/9 21:41
 * @Version 1.0
 * 目标：什么是线程池。
 * ===
 * 线程池:其实就是一个容纳多个线程的容器,其中的线程可以反复的使用，
 * 省去了频繁创建和销毁线程对象的操作,无需反复创建线程而消耗过多资源。
 * ===
 * 为什么要用线程池：
 * 合理利用线程池能够带来三个好处
 * 1.降低资源消耗。
 * -- 减少了创建和销毁线程的次数，每个工作线程都
 * 可以被重复利用，可执行多个任务。
 * ===
 * 2.提高响应速度
 * -- 不需要频繁的创建线程，如果有
 * 线程可以直接用，不会出现系统僵死！
 * ===
 * 3.提高线程的可管理性（线程池可以约束系统最多只能有多少个线程，
 * 不会因为线程过多而死机）
 * ===
 * 线程池的核心思想：线程复用，同一个线程可以被重复使用，来处理多个任务。
 * ==========================
 * ==========================
 * 线程池在Java中的代表类：ExecutorService(接口)。
 * ===
 * Java在Executors类下提供了一个静态方法得到一个线程池的对象：
 * -------1.public static ExecutorService newFixedThreadPool(int nThreads)：
 * ---创建一个线程池返回。
 * ===
 * ExecutorService提交线程任务对象执行的方法：
 * -------1.Future<?> submit(Runnable task):提交一个Runnable的任务对象给线程池执行。
 * -------1.Future<?> submit(Callable task):提交一个Runnable的任务对象给线程池执行。
 * 小结：
 * pools.shutdown(); // 等待任务执行完毕以后才会关闭线程池
 * pools.shutdownNow(); // 立即关闭线程池的代码，无论任务是否执行完毕！
 * Callable做线程池的任务，可以得到它执行的结果！！
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        //创建一个线程池，指定线程的固定数量是3
//        ExecutorService pools = Executors.newFixedThreadPool(3);
//        //添加线程任务让线程池处理
//        Runnable target = new MyRunnable();
//        pools.submit(target);  //第一次提交任务，此时线程池创建新线程，自动触发执行
//        pools.submit(target);  //第二次提交任务，此时线程池创建新线程，自动触发执行
//        pools.submit(target);  //第三次提交任务，此时线程池创建新线程，自动触发执行
//        pools.submit(target);  //第四次提交任务，复用之前的线程
//
//        pools.shutdown();       //等待任务执行完毕以后才会关闭线程池
//        pools.shutdownNow();    //立即关闭线程池的代码，无论任务是否执行完毕


        ExecutorService pools = Executors.newFixedThreadPool(3);
        //提交 Callable 的任务对象后返回一个未来任务对象
        Future<String> t1 = pools.submit(new MyCallable(100));
        Future<String> t2 = pools.submit(new MyCallable(200));
        Future<String> t3 = pools.submit(new MyCallable(300));
        Future<String> t4 = pools.submit(new MyCallable(400));
        //获取线程池执行的结果
        try {
            System.out.println(t1.get());
            System.out.println(t2.get());
            System.out.println(t3.get());
            System.out.println(t4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}

class MyCallable implements Callable {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //使用线程池，计算 1-100  1-200  1-300 的和并返回
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return Thread.currentThread().getName() + "执行的结果是：" + sum;
    }
}
