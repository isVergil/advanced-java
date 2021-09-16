package com.juc.test;

import com.javabasic.packagedemo.Fu;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CreateThread
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 19:46
 * @Version 1.0
 **/
/*
线程创建方式
1、线程类 lambda 写法
2、线程任务类（任务抽离出来） lambda 写法
3、FutureTask 用来返回任务结果
---FutureTask 实现了 RunnableFuture 接口
---RunnableFuture 继承了 Runnable 和 Future<V>
---因此可以作为线程来执行任务和返回执行结果(Future.get();)
---阻塞等待结果的返回
 */
@Slf4j(topic = "c.CreateThread")
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1、线程类
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.debug("线程类 running");
            }
        };
        t1.start();
        log.debug("mian running");
        //精简 java8 以后 函数式接口用 lambda 简化
        Thread t1_1 = new Thread(() -> log.debug("线程类简化写法 running"));

        //2、线程任务类
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                log.debug("线程任务类 running");
            }
        };
        Thread t2 = new Thread(task1);
        t2.start();
        //精简 java8 以后 函数式接口用 lambda 简化
        Runnable t2_1 = () -> log.debug("线程类简化写法 running");

        //3、FutureTask
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running");
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread t3 = new Thread(futureTask, "t3");
        t3.start();
        //阻塞等待结果返回
        log.debug("{}",futureTask.get());

    }
}


