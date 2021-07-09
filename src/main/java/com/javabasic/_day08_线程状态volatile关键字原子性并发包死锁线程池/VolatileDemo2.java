package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池;

/**
 * @ClassName VolatileDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/9 22:51
 * @Version 1.0
 **/

/***
      某一个线程进入synchronized代码块前后，执行过程入如下：
             a.线程获得锁
             b.清空工作内存
             c.从主内存拷贝共享变量最新的值到工作内存成为副本
             d.执行代码
             e.将修改后的副本的值刷新回主内存中
             f.线程释放锁
 */
public class VolatileDemo2 {
    public static void main(String[] args) {
        //启动子线程，修改flag的值为true
        VolatileThread volatileThread = new VolatileThread();
        volatileThread.start();

        //主线程
        while (true) {
            //加锁
            synchronized (VolatileDemo2.class) {
                if (volatileThread.isFlag()) {
                    System.out.println("主线程进入执行");
                }
            }

        }
    }
}
