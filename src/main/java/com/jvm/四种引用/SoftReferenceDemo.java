package com.jvm.四种引用;


import org.junit.Test;

import java.lang.ref.SoftReference;

/**
 * @ClassName SoftReferenceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/9/1 21:52
 * @Version 1.0
 **/
public class SoftReferenceDemo {

    public static void main(String[] args) {
        softRef_Memory_NotEnough();
    }

    ///内存够用的时候
    @Test
    public void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    //JVM 配置，故意产生大对象并配置小的内存，让它的内存不够用了导致OOM，看软引用的回收情况
    //* -Xms5m -Xmx5m -XX:+PrintGCDetails
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        o1 = null;
        try {
            //oom 自动 gc
            //30m
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }
}
