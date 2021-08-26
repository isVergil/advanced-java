package com.juc.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 读写锁
 * @Param:
 * @Return:
 * @Author: bill
 * @Date: 2021/8/27 3:07
 */
/*
原来我们使用ReentrantLock 创建锁的时候，是独占锁，也就是说一次只能一个线
程访问，但是有一个读写分离场景，读的时候想同时进行，因此原来独占锁的并发
性就没这么好了，因为读锁并不会造成数据不一致的问题，因此可以多个人共享读
多个线程 同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可
以同时进行，但是如果一个线程想去写共享资源，就不应该再有其它线程可以对该资源进
行读或写
读-读：能共存
读-写：不能共存
写-写：不能共存
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    myCache.put(temp + "", temp + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                try {
                    myCache.get(temp + "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) throws Exception {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            //暂停线程
            Thread.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：" + key);
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) throws Exception {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
            //暂停线程
            Thread.sleep(300);
            Object object = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + object);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}
