package com.jvm.四种引用;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @ClassName WeakReferenceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/9/1 22:06
 * @Version 1.0
 **/
/*
不管内存是否够，只要有GC 操作就会进行回收
弱引用需要用 java.lang.ref.WeakReference 类来实现，它比软引用生存期更短
对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM 的内存空间是
否足够，都会回收该对象占用的空间。
 */
public class WeakReferenceDemo {
    public static void main(String[] args) {
        //WeakReferenceTest();
        WeakHashMapTest();
    }

    private static void WeakReferenceTest() {
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object);
        object = null;
        System.gc();
        System.out.println(object);
        System.out.println(weakReference.get());
    }

    private static void WeakHashMapTest() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(1);
        String value = "value";
        map.put(key, value);
        System.out.println(map);
        key = null;
        System.gc();
        System.out.println(map);
    }

}
