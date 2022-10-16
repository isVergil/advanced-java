package com.juc.并发包;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureBuildDemo
 * @Description TODO
 * @Author bill
 * @Date 2022/6/13 0:09
 * @Version 1.0
 **/
public class CompletableFutureBuildDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "--------副线程come in");
                int result = ThreadLocalRandom.current().nextInt(10);//产生随机数
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----结果-----"+result);
                if (result > 2) {
                    int i = 10 / 0;//我们主动的给一个异常情况
                }
                return result;
            }, threadPool).whenComplete((v, e) -> {//没有异常,v是值，e是异常
                if (e == null) {
                    System.out.println("------------------计算完成，更新系统updataValue" + v);
                }
            }).exceptionally(e -> {//有异常的情况
                e.printStackTrace();
                System.out.println("异常情况" + e.getCause() + "\t" + e.getMessage());
                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }


        //线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭：暂停3秒钟线程
        //System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        //try {
        //    TimeUnit.SECONDS.sleep(3);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
    }

    public static void main2() throws ExecutionException, InterruptedException {
        //runAsync 无返回值
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            //ForkJoinPool.commonPool-worker-9
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, threadPool);
        System.out.println(completableFuture.get());

        //supplyAsync有返回值
        ExecutorService executorService = Executors.newFixedThreadPool(3);//加入线程池

        CompletableFuture<String> objectCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "helllo supplyasync";
        }, executorService);
        System.out.println(objectCompletableFuture.get());
    }

}
