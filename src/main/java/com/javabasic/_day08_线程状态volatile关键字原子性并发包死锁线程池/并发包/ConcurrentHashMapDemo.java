package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池.并发包;

/**
 * @ClassName ConcurrentHashMapDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/10 16:20
 * @Version 1.0
 **/

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/***
 * 目标：并发包的介绍。(面试的重点中的重点)
 *
 *     并发包的来历：
 *         在实际开发中如果不需要考虑线程安全问题，大家不需要做线程安全，因为如果做了反而性能不好！
 *         但是开发中有很多业务是需要考虑线程安全问题的，此时就必须考虑了。否则业务出现问题。
 *         Java为很多业务场景提供了性能优异，且线程安全的并发包，程序员可以选择使用！
 *
 *     Map集合中的经典集合：HashMap它是线程不安全的，性能好
 *         -- 如果在要求线程安全的业务情况下就不能用这个集合做Map集合，否则业务会崩溃~
 *     为了保证线程安全，可以使用Hashtable。注意：线程中加入了计时
 *         -- Hashtable是线程安全的Map集合，但是性能较差！(已经被淘汰了，虽然安全，但是性能差)
 *         -- 锁定整个 hashtable
 *     为了保证线程安全，再看ConcurrentHashMap（不止线程安全，而且效率高，性能好，最新最好用的线程安全的Map集合）
 *         -- ConcurrentHashMap保证了线程安全，综合性能较好！
 *         -- 使用 CAS + 局部(synchronized)锁定**分段式锁（锁定桶，当前元素及其链表（红黑树）锁定，其他元素不锁）
 *         -- 只锁自己操作的元素位置，综合性能好
 *
 *     小结：
 *         HashMap是线程不安全的。
 *         Hashtable线程安全基于synchronized，综合性能差,被淘汰了。
 *         ConcurrentHashMap：线程安全的，分段式锁，综合性能最好，线程安全开发中推荐使用
 *
 *    下面例子Hashtable性能反而比ConcurrentHashMap好 见：https://www.bilibili.com/video/BV1TE41177mP?p=178&spm_id_from=pageDriver
 */
public class ConcurrentHashMapDemo {
    //public static Map<String, String> maps = new HashMap<>(); 线程不安全，同时存数据
    //public static Hashtable<String, String> maps = new Hashtable<>();  //线程安全，性能较差（悲观极了）
    public static Map<String, String> maps = new ConcurrentHashMap<>();  //线程安全，性能提升了

    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable, "线程一");
        Thread t2 = new Thread(runnable, "线程二");
        t1.start();
        t2.start();

        try {
            t1.join();  //让t1跑完 主线程不抢该线程 t2 抢
            t2.join();  //让t2跑完 主线程不抢该线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(maps.size());
        

    }
}

//加锁
class MyRunnable implements Runnable {

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 100000; i++) {
            ConcurrentHashMapDemo.maps.put(Thread.currentThread().getName() + i, i + "");
        }
        long end = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "耗时" + (end - start) / 1000.0);
    }
}
