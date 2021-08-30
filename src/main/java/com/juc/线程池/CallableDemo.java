package com.juc.线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CallableDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/30 21:20
 * @Version 1.0
 **/
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable thread = new myThread2();
        FutureTask futureTask = new FutureTask(thread);
        Thread t1 = new Thread(futureTask, "AA");
        t1.start();
        //自旋
        while (!futureTask.isDone()) {

        }
        //get  会阻塞线程（可能阻塞其他线程） 直到计算完成  所以一般放在最后
        System.out.println(futureTask.get());
    }
}

class myThread1 implements Runnable {

    @Override
    public void run() {

    }

}

//带返回值的线程创建方式
class myThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "call";
    }
}
