package com.thread;

/**
 * @ClassName UseThread
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 20:20
 * @Version 1.0
 **/
public class UseThread {
    public static void main(String[] args) {

    }

    //在没有利用 cpu 来计算时，不要让 while(true) 空转浪费 cpu，这时可以使用 yield 或 sleep 来让出 cpu 的使用权给其他程序
//    可以用 wait 或 条件变量达到类似的效果
//    不同的是，后两种都需要加锁，并且需要相应的唤醒操作，一般适用于要进行同步的场景
//    sleep 适用于无需锁同步的场景
    private static void useSleep() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
