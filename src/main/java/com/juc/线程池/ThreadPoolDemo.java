package com.juc.线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 21:55
 * @Version 1.0
 **/
/*
线程池做的主要工作就是控制运行的线程的数量，处理过程中，将任务放入到队列中，然后线程创建后，启动这些任务，如果线程数量超过了最大数量的线程排队等候，等其它线程执行完毕，再从队列中取出任务来执行。
它的主要特点为：线程复用、控制最大并发数、管理线程线程池中的任务是放入到阻塞队列中的

多核处理的好处是：省略的上下文的切换开销
原来我们实例化对象的时候，是使用 new 关键字进行创建，到了Spring 后，我们学了IOC 依赖注入，发现Spring 帮我们将对象已经加载到了Spring 容器中，只需
要通过@Autowrite 注解，就能够自动注入，从而使用因此使用多线程有下列的好处
• 降低资源消耗。通过重复利用已创建的线程，降低线程创建和销毁造成的消耗
• 提高响应速度。当任务到达时，任务可以不需要等到线程创建就立即执行
• 提高线程的可管理性。线程是稀缺资源，如果无线创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控

Java 中线程池是通过Executor 框架实现的，该框架中用到了Executor，Executors（代表工具类），ExecutorService，ThreadPoolExecutor 这几个类。
5种创建方法

1、Executors.newFixedThreadPool(int i) ：创建一个拥有 i 个线程的线程池
–----- 执行长期的任务，性能好很多
–----- 创建一个定长线程池，可控制线程数最大并发数，超出的线程会在队列中等待
–----- 一池固定线程

2、Executors.newSingleThreadExecutor：创建一个只有1 个线程的 单线程池
–----- 一个任务一个任务执行的场景
–----- 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序执行
–----- 一池一线程

3、Executors.newCacheThreadPool(); 创建一个可扩容的线程池
–----- 执行很多短期异步的小程序或者负载教轻的服务器
–----- 创建一个可缓存线程池，如果线程长度超过处理需要，可灵活回收空闲线程，如无可回收，则新建新线程
–----- 一池N线程

//下面两种不常用
4、Executors.newScheduledThreadPool(int corePoolSize)：线程池支持定时以及周期性执行任务，创建一个corePoolSize 为传入参数，最大线程数为整形的最大数的线程池
–----- 带时间调度的

5、Executors.newWorkStealingPool(int)：
–----- java8 新增
–----- 使用目前机器上可用的处理器作为他的并行级别
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        //一池 5 线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一池 1 线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //一池 N 线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //模拟 10 个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                //暂停一会儿
                //Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

}
