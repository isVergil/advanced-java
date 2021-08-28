package com.juc.阻塞队列;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName BlockingQueueDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/27 16:30
 * @Version 1.0
 **/
/*
线程1 往阻塞队列中添加元素，而线程2 从阻塞队列中移除元素
• 当阻塞队列是空时，从队列中获取元素的操作将会被阻塞
• 当阻塞队列是满时，从队列中添加元素的操作将会被阻塞

BlockingQueue 阻塞队列是属于一个接口，底下有七个实现类
1•*** ArrayBlockQueue：由数组结构组成的有界阻塞队列
2•*** LinkedBlockingQueue：由链表结构组成的有界（但是默认大小 Integer.MAX_VALUE）的阻塞队列 , 有界，但是界限非常大，相当于无界，可以当成无界
3• PriorityBlockQueue：支持优先级排序的无界阻塞队列
4• DelayQueue：使用优先级队列实现的延迟无界阻塞队列
5•*** SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列 生产一个，消费一个，不存储元素，不消费不生产
6• LinkedTransferQueue：由链表结构组成的无界阻塞队列
7• LinkedBlockingDeque：由链表结构组成的双向阻塞队列


 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception {
//        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        System.out.println(blockingQueue.offer("a", 2l, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("b", 2l, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("c", 2l, TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d", 2l, TimeUnit.SECONDS));

        //同步队列
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "\t put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + "\t put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + "\t put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "\t take");
                System.out.println(blockingQueue.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "\t take");
                System.out.println(blockingQueue.take());

                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "\t take");
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();

    }
}