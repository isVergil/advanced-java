package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.HashSet;

/**
 * @ClassName LinkedHashSetDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 16:04
 * @Version 1.0
 * 目标:LinkedHashSet
 * ---
 * 是HashSet的子类，元素是“有序” 不重复，无索引.
 * ---
 * LinkedHashSet底层依然是使用哈希表存储元素的，
 * 但是每个元素都额外带一个链来维护添加顺序！！
 * 不光增删查快，还有序。缺点是多了一个存储顺序的链会占内存空间!!而且不允许重复，无索引。
 * ---
 * 总结：
 * 如果希望元素可以重复，又有索引，查询要快用ArrayList集合。（用的最多）
 * 如果希望元素可以重复，又有索引，增删要快要用LinkedList集合。（适合查询元素比较少的情况，经常要首尾操作元素的情况）
 * 如果希望增删改查都很快，但是元素不重复以及无序无索引，那么用HashSet集合。
 * 如果希望增删改查都很快且有序，但是元素不重复以及无索引，那么用LinkedHashSet集合。
 **/
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        HashSet<Apple> apples = new HashSet<>();
        apples.add(new Apple("1", 1));
        apples.add(new Apple("2", 2));
        apples.add(new Apple("3", 3));
        System.out.println(apples);
    }
}
