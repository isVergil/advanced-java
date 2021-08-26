package com.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName LockDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/26 22:46
 * @Version 1.0
 **/
public class LockDemo {
    public static void main(String[] args) {
        //不加参数是非公平锁
        //true为公平锁
        //Lock lock = new ReentrantLock(true);
        //ReentrantReadWriteLock
    }
}
