package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName IteratorDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/4 15:42
 * @Version 1.0
 * -----------Collection 遍历方式------------
 * 在程序开发中，经常需要遍历集合中的所有元素。针对这种需求，JDK专门提供了一个接口`java.util.Iterator`。
 * 想要遍历Collection集合，那么就要获取该集合迭代器完成迭代操作，下面介绍一下获取迭代器的方法：
 * Collection 集合的三种遍历方式：
 * 1、迭代器（集合）
 * 2、foreach（增强for循环）（集合或者数组）
 * 3、JDK1.8 开始之后的新技术 lambda 表达式
 * -
 * -----------------------------------------------------------------------------------
 * -1、迭代器遍历 游标 （集合）
 * --`public Iterator iterator()`: 获取集合对应的迭代器，用来遍历集合中的元素的。
 * --`public E next()`:返回迭代的下一个元素。
 * --`public boolean hasNext()`:如果仍有元素可以迭代，则返回 true。
 * --异常 NoSuchElementException
 * -----------------------------------------------------------------------------------
 * -2、foreach（增强for循环）
 * -- foreach 是一种遍历形式，可以遍历集合或者数组
 * -- foreach 是迭代器遍历的简化写法
 * -- 缺点： 无法知道遍历到哪，没有索引
 * -----------------------------------------------------------------------------------
 * -3、lambda 表达式遍历
 * -- collection.foreach(s->{
 * -------sout(s);
 * --}
 **/
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        collection.add("4");

        //得到集合的迭代器对象
        Iterator<String> iterator = collection.iterator();
        //System.out.println(iterator.next());

        //使用while循环遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //foreach 遍历
        for (String ele : collection) {
            System.out.println(ele);
        }

        //lambda 表达式遍历
        collection.forEach(s -> {
            System.out.println(s);
        });
        collection.forEach(s -> System.out.println(s));
        collection.forEach(System.out::println);

    }
}
