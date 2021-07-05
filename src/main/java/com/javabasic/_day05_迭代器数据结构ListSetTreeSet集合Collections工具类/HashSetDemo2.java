package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.HashSet;

/**
 * @ClassName HashSetDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 15:39
 * @Version 1.0
 * 目标:Set系列集合元素无序的根本原因。(面试必考)
 * ---
 * Set系列集合添加元素无序的根本原因是因为底层采用了哈希表存储元素。
 * ---
 * JDK 1.8之前：哈希表 = 数组 + 链表  + （哈希算法）
 * JDK 1.8之后：哈希表 = 数组 + 链表 + 红黑树 (地址大的右边，小左边)  + （哈希算法）
 * 当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。
 * ---
 * ---https://blog.csdn.net/qq_32635069/article/details/79798741
 * //默认的容量，容量必须是2的幂  16
 * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
 * //最大容量2的30次方
 * static final int MAXIMUM_CAPACITY = 1 << 30;
 * //默认装填因子0.75
 * static final float DEFAULT_LOAD_FACTOR = 0.75f;
 * ---
 * 小结：
 * ----------Set系列集合是基于哈希表存储数据的
 * ----------它的增删改查的性能都很好！！但是它是无序不重复的（先添加的元素可能跑后面去了）！如果不在意当然可以使用！
 **/
public class HashSetDemo2 {
    public static void main(String[] args) {
        HashSet<Apple> apples = new HashSet<>();
        apples.add(new Apple("红富士", 12));
        apples.add(new Apple("红富士", 12));
        apples.add(new Apple("红富士1", 12));
        System.out.println(apples);
    }
}
