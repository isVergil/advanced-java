package com.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/26 14:53
 * @Version 1.0
 **/
/*
CAS 的全称是Compare-And-Swap，它是 CPU 并发原语
它的功能是判断内存某个位置的值是否为预期值，如果是则更改为新的值，这个过程是原子的
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2014) + "\t current data:" + atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
