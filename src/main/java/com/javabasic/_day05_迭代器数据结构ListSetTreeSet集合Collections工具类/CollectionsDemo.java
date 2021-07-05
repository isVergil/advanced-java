package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.*;

/**
 * @ClassName CollectionsDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 21:45
 * @Version 1.0
 * 目标：Collections工具类的使用。
 * ---
 * java.utils.Collections:是集合工具类
 * Collections并不属于集合，是用来操作集合的工具类。
 * Collections有几个常用的API:
 * - public static <T> boolean addAll(Collection<? super T> c, T... elements)
 * 给集合对象批量添加元素！
 * - public static void shuffle(List<?> list) :打乱集合顺序。set集合打乱不了（哈希值求得的位置）
 * - public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
 * - public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。
 * ------------------
 * 字符串按照首字符的编号升序排序！
 * -
 * 自定义类型的比较方法API:
 * - public static <T> void sort(List<T> list):
 * 将集合中元素按照默认规则排序。
 * 对于自定义的引用类型的排序人家根本不知道怎么排，直接报错！
 * 如果希望自定义的引用类型排序不报错，可以给类提供比较规则:Comparable。
 * -
 * - public static <T> void sort(List<T> list，Comparator<? super T> c):
 * 将集合中元素按照指定规则排序,自带比较器
 * 注意：如果类有比较规则，而这里有比较器，优先使用比较器。
 * -
 * -
 * -
 * -------? extends T 与 ? super T
 * java的一个设计理念是，与泛型相关的异常最好是在编译期间就被发现，因此设计了extends与super这两种方式。
 * 具体来说，List<? extends T>表示该集合中存在的都是类型T的子类，包括T自己。
 * 而List<? super T>表示该集合中存的都是类型T的父类，包括T自己。
 * List<? extends T>如果去添加元素的时候，因为list中存放的其实是T的一种子类，如果我们去添加元素，其实不知道到底应该添加T的哪个子类，这个时候桥接方法在进行强转的时候会出错。但是如果是从集合中将元素取出来，我们可以知道取出来的元素肯定是T类型。所以? extends T这种方式可以取元素而不能添加，这个叫get原则。
 * List<? super T>因为存的都是类型T的父类，所以如果去添加T类或者T类子类的元素，肯定是可以的。但是如果将元素取出来，则不知道到底是什么类型，所以? super T可以添加元素但是没法取出来，这个叫put原则。
 * ————————————————
 **/
public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "1", "2", "3", "4", "5", "6");
        System.out.println(names);
        Collections.shuffle(names);
        //shuffle 洗牌
        System.out.println(names);
        //排序1 默认升序
        Collections.sort(names);
        System.out.println(names);
        //排序2 自定义比较规则
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("1", 1));
        apples.add(new Apple("2", 2));
        apples.add(new Apple("3", 3));
        apples.add(new Apple("4", 4));
        apples.add(new Apple("5", 5));
        Collections.sort(apples, (o2, o1) -> (o1.getAge() - o2.getAge()));
//        Collections.sort(apples, new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return 0;
//            }
//        });
        System.out.println(apples);
    }
}
