package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.LinkedList;

/**
 * @ClassName LinkedListDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 15:04
 * @Version 1.0
 * 目标：LinkedList集合。
 * <p>
 * Collection集合的体系:
 * Collection<E>(接口)
 * /                                       \
 * Set<E>(接口)                             List<E>(接口)
 * /                                   /                    \               \
 * HashSet<E>(实现类)                   LinkedList<E>(实现类) Vector(实现类)  ArrayList<E>(实现类)
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
 * <p>
 * LinkedList也是List的实现类：底层是基于链表的，增删比较快，查询慢！！
 * LinkedList是支持双链表，定位前后的元素是非常快的，增删首尾的元素也是最快的
 * 所以LinkedList除了拥有List集合的全部功能还多了很多操作首尾元素的特殊功能：
 * - public void addFirst(E e):将指定元素插入此列表的开头。
 * - public void addLast(E e):将指定元素添加到此列表的结尾。
 * - public E getFirst():返回此列表的第一个元素。
 * - public E getLast():返回此列表的最后一个元素。
 * - public E removeFirst():移除并返回此列表的第一个元素。
 * - public E removeLast():移除并返回此列表的最后一个元素。
 * - public E pop():从此列表所表示的堆栈处弹出一个元素。
 * - public void push(E e):将元素推入此列表所表示的堆栈。
 * <p>
 * 小结：
 * LinkedList是支持双链表，定位前后的元素是非常快的，增删首尾的元素也是最快的。
 * 所以提供了很多操作首尾元素的特殊API可以做栈和队列的实现。
 * <p>
 * 如果查询多而增删少用ArrayList集合。(用的最多的)
 * 如果查询少而增删首尾较多用LinkedList集合。
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        //LinkedList 作队列
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        queue.addLast("4号");
        queue.addLast("5号");
        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        //LinkedList 作栈
        LinkedList<String> stack = new LinkedList<>();
        stack.push("1号");
        stack.push("2号");
        stack.push("3号");
        stack.push("4号");
        stack.push("5号");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
