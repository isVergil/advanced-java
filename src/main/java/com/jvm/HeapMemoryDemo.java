package com.jvm;

/**
 * @ClassName HeapMemoryDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/20 16:11
 * @Version 1.0
 * jps
 * jmap -heap id
 **/
public class HeapMemoryDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("1----------");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10];   //10Mb
        System.out.println("2----------");
        Thread.sleep(20000);
        array = null;
        System.gc();
        System.out.println("3----------");
        Thread.sleep(3000000L);

    }
}
