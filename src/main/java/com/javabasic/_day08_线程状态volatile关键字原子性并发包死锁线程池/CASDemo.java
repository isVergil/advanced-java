package com.javabasic._day08_线程状态volatile关键字原子性并发包死锁线程池;

/**
 * @ClassName CASDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/10 16:10
 * @Version 1.0
 **/

/***
 * CAS的全成是： Compare And Swap(比较再交换); 是现代CPU广泛支持的一种对内存中的共享数据进行操作的一种特殊指令。CAS可以将read-modify-check-write
 * 转换为原子操作，这个原子操作直接由处理器保证。
 * CAS机制当中使用了3个基本操作数：内存地址V，旧的预期值A，要修改的新值B。
 *
 * #### CAS与Synchronized：乐观锁，悲观锁。
 *
 * CAS和Synchronized都可以保证多线程环境下共享数据的安全性。那么他们两者有什么区别？
 *     1、Synchronized是从悲观的角度出发（悲观锁）
 *          总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁
 *         （**共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程**）。因此Synchronized我们也将其称之为**悲观锁**。jdk中的ReentrantLock也是一种悲观锁。性能较差！！
 *
 *     2、CAS是从乐观的角度出发: 值用 volatile 修饰 能更快的拿到值 性能更好
 *          总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据。
 *          CAS这种机制我们也可以将其称之为乐观锁。综合性能较好！
 */
public class CASDemo {
    public static void main(String[] args) {

    }
}
