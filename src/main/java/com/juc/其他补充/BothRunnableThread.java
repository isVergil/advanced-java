package com.juc.其他补充;

/**
 * @ClassName BothRunnableThread
 * @Description 同时使用 Runnable 和 Thread 两种实现线程的方式
 * @Author bill
 * @Date 2022/2/25 0:39
 * @Version 1.0
 **/
public class BothRunnableThread {

    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override  //Runnable对象
            public void run() {
                System.out.println("Runnable");
            }
        }) {
            @Override
            //重写 thread 类的 run 方法 会覆盖 Runnable 的run方法
            //Runnable 的 target 不会执行
            public void run() {
                System.out.println("thread");
            }
        }.start();
    }

}
