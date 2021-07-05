package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName ArrayListDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 14:40
 * @Version 1.0
 * Collection集合的体系:
 * -----------------------------------Collection<E>(接口)
 * --------------------/                                                \
 * --------Set<E>(接口)                                                List<E>(接口)
 * -----/                  \                               /                     \                  \
 * HashSet<E>(实现类)    TreeSet<E>(实现类)          LinkedList<E>(实现类)    Vector(线程安全)     ArrayList<E>(实现类)
 * /
 * LinkedHashSet<E>(实现类)
 * <p>
 * Collection集合体系的特点:
 * Set系列集合： 添加的元素，是无序，不重复，无索引的。
 * -- HashSet：添加的元素，是无序，不重复，无索引的。
 * -- LinkedHashSet：添加的元素，是有序，不重复，无索引的。
 * List系列集合：添加的元素，是有序，可重复，有索引的。
 * -- LinkedList： 添加的元素，是有序，可重复，有索引的。
 * -- ArrayList： 添加的元素，是有序，可重复，有索引的。
 * -- Vector 是线程安全的，速度慢，工作中很少使用。
 * <p>
 * List集合继承了Collection集合的全部功能，同时因为List系列集合有索引，
 * 因为List集合多了索引，所以多了很多按照索引操作元素的功能:
 * ArrayList实现类集合底层基于数组存储数据的，查询快，增删慢！
 * - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
 * - public E get(int index):返回集合中指定位置的元素。
 * - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。
 * - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回更新前的元素值。
 * ---小结：
 * ----1、List系列集合有序，可重复，有索引的。
 * ----2、ArrayList实现类集合底层基于数组存储数据的，查询快，增删慢！！
 * ----3、开发中ArrayList集合用的最多！！
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        //ArrayList
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list.get(3));
        System.out.println(list.remove(0));
        list.set(0, "6");
        System.out.println(list);

        //遍历
        query(list);


    }

    //4中遍历方式
    public static void query(Collection<?> list) {
        //迭代器循环
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");

        //foreach
        for (Object s : list) {
            System.out.println(s);
        }
        System.out.println("-----------------");

        //lambda表达式
        list.forEach(System.out::println);
        //list.forEach(s -> System.out.println(s));
        System.out.println("-----------------");

        //for循环
        Object[] arrays = list.toArray();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(arrays[i]);
        }
    }
}
