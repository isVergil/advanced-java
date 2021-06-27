package com.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * @ClassName CreateThread
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 14:10
 * @Version 1.0
 * 线程的3种创建方法
 * java 8 之后 lambda 表达式精简代码
 * Runnable 接口中只有1个抽象方法，这样的接口叫做 @FunctionalInterface 函数式接口  可以被 lambda 表达式来简化
 * <p>
 * 第一种 是把线程和任务合并在了一起
 * 第二种 是把线程和任务分开了，用 Runnable 更容易与线程池等高级 API 配合，用 Runnable 让任务类脱离了 Thread 继承体系，更灵活。
 * 组合优于继承
 * <p>
 * 第四种 FutureTask能够接受Callable；类型的参数，用来处理有返回结果的情况
 * Future 就是对于具体的 Runnable 或者 Callable 任务的执行结果进行取消、查询是否完成、获取结果。必要时可以通过 get 方法获取执行结果，该方法会阻塞直到任务返回结果。
 **/
@Slf4j(topic = "c.CreateThread")
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一种 是把线程和任务合并在了一起
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                log.debug("running");
//            }
//        };
//        t.setName("t1");
//        t.start();
//        log.debug("running");


        //第二种 是把线程和任务分开了，用 Runnable 更容易与线程池等高级 API 配合，用 Runnable 让任务类脱离了 Thread 继承体系，更灵活。
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                log.debug("running");
//            }
//        };
//        Thread t = new Thread(run);
//        t.start();

        //第三种
        //只有一行语句 大括号可以省略
        //Runnable run = () -> log.debug("running");
//        Runnable run = () -> {
//            log.debug("running");
//        };
//        Thread t = new Thread(run, "t2");
//        t.start();
//
//        //进一步简化
//        new Thread(() -> {
//            log.debug("running");
//        }, "t3").start();

        //第四种
        //FutureTask(任务对象) 配合 Thread
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                log.debug("running");
                Thread.sleep(1000);
                return 1000;
            }
        });
        Thread t = new Thread(task, "t1");
        t.start();
        log.debug("{}",task.get());

    }
}
