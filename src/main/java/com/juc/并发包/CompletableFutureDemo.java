package com.juc.并发包;

import java.util.concurrent.*;

/**
 * @ClassName CompletableFutureDemo
 * @Description TODO
 * @Author bill
 * @Date 2022/6/12 23:08
 * @Version 1.0
 **/
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "task1 over";
        });
        threadPool.submit(futureTask2);

        futureTask2.get();

        while (true) {
            if (futureTask1.isDone()) {
                System.out.println(futureTask1.get());
                break;
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    System.out.println("---正在轮询");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("---------cost:" + (endTime - startTime));
        System.out.println("---------end");
    }
}

class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("------come int call()------");
        return "hello call";
    }
}
