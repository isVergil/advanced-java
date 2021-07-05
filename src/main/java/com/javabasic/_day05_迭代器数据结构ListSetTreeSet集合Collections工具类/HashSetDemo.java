package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HashSetDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 15:13
 * @Version 1.0
 * 目标：HashSet集合
 * <p>
 * Collection集合的体系:
 * Collection<E>(接口)
 * /                                       \
 * Set<E>(接口)                             List<E>(接口)
 * /             \                             /                     \               \
 * HashSet<E>(实现类) TreeSet<E>(实现类)       LinkedList<E>(实现类) Vector(线程安全)     ArrayList<E>(实现类)
 * /
 * LinkedHashSet<E>(实现类)
 * -----------
 * Collection集合体系的特点:
 * Set系列集合： 添加的元素，是无序，不重复，无索引的。
 * -- HashSet：添加的元素，是无序，不重复，无索引的（遍历不能用索引遍历）。
 * -- LinkedHashSet：添加的元素，是有序，不重复，无索引的。
 * -- TreeSet: 不重复，无索引，按照大小默认升序排序!! ( 可排序集合 )
 * List系列集合：添加的元素，是有序，可重复，有索引的。
 * -- LinkedList： 添加的元素，是有序，可重复，有索引的。底层是基于链表存储数据的，查询慢，增删快
 * -- ArrayList： 添加的元素，是有序，可重复，有索引的。底层基于数组存储数据的，查询快，增删慢
 * -----------
 * 研究两个问题(面试热点)：
 * 1）Set集合添加的元素是不重复的，是如何去重复的？
 * 2）Set集合元素无序的原因是什么？
 **/
public class HashSetDemo {
    public static void main(String[] args) {
        //是无序(指添加的元素无序)，不重复，无索引的
        Set<String> sets = new HashSet<>();
        sets.add("1");
        sets.add("2");
        sets.add("2");
        sets.add("3");
        sets.add("4");
        sets.add("5");
        System.out.println(sets);
    }
}
