package com.juc.生产者消费者;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ProducerConsumer_BlockQueueDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/28 19:40
 * @Version 1.0
 **/
public class ProducerConsumer_BlockQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        //生产线程
        new Thread(() -> {
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        //消费线程
        new Thread(() -> {
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        Thread.sleep(1000);
        System.out.println("===========");
        myResource.stop();
        System.out.println("结束===========");
    }
}


class MyResource {
    //默认开启，进行生产+消费
    private volatile boolean FLAG = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    //生产
    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2l, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + " 成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列 " + data + " 失败");
            }
            Thread.sleep(100);
        }
        System.out.println(Thread.currentThread().getName() + "\t 生产结束 FLAG = false ");

    }

    //消费
    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2l, TimeUnit.SECONDS);
            if (result == null || result.equals("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有取到消费失败，退出 ");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列 " + result + " 成功");
            Thread.sleep(100);
        }
    }

    public void stop() {
        this.FLAG = false;
    }
}
