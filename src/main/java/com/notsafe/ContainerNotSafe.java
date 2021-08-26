package com.notsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName ContainerNotSafe
 * @Description TODO
 * @Author bill
 * @Date 2021/8/26 16:28
 * @Version 1.0
 **/
//java.util.ConcurrentModificationException  并发修改异常
//ArrayList 、HashSet 、Map 都不安全
//改用线程安全
//1、List<String> list = new Vector<>();   jdk 1.0 提供的
//2、List<String> list = Collections.synchronizedList(new ArrayList<>());  Collections 工具类提供的  synchronizedMap
//3、List<String> list = new CopyOnWriteArrayList<>();  CopyOnWriteArraySet、 ConcurrentHashMap

public class ContainerNotSafe {
    public static void main(String[] args) {
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        //HashSet  default initial capacity (16) and load factor (0.75).
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
