package com.juc;

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author bill
 * @Date 2022/4/17 0:03
 * @Version 1.0
 **/
public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.get();
    }

}
