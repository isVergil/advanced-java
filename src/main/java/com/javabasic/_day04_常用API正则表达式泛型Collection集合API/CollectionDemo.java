package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @ClassName CollectionDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 23:58
 * @Version 1.0
 * 目标：Collection集合概述。
 * <p>
 * 什么是集合?
 * 集合是一个大小可变的容器。
 * 容器中的每个数据称为一个元素。数据==元素。
 * 集合的特点是：类型可以不确定，大小不固定。集合有很多种，不同的集合特点和使用场景不同。
 * 数组：类型和长度一旦定义出来就都固定了。
 * <p>
 * 集合有啥用？
 * 在开发中，很多时候元素的个数是不确定的。
 * 而且经常要进行元素的增删该查操作，集合都是非常合适的。
 * 开发中集合用的更多!!
 * <p>
 * Java中集合的代表是：Collection.
 * Collection集合是Java中集合的祖宗类。
 * 学习Collection集合的功能，那么一切集合都可以用这些功能！！
 * <p>
 * Collection集合的体系:
 * -------------------------Collection<E>(接口)
 * ---------------------/                        \
 * ----------Set<E>(接口)                           List<E>(接口)
 * ---------/               \                    /                \
 * HashSet<E>(实现类)  TreeSet<>(实现类)    ArrayList<E>(实现类)  LinekdList<>(实现类)
 * -----/
 * LinkedHashSet<>(实现类)
 * <p>
 * 集合的特点：
 * Set系列集合：添加的元素是无序，不重复，无索引的。
 * -- HashSet:添加的元素是无序，不重复，无索引的。
 * -- LinkedHashSet:添加的元素是有序，不重复，无索引的。
 * -- TreeSet:不重复，无索引，按照大小默认升序排序!!
 * List系列集合：添加的元素是有序，可重复，有索引。
 * -- ArrayList：添加的元素是有序，可重复，有索引。
 * -- LinekdList：添加的元素是有序，可重复，有索引。
 * 小结：
 * Collection是集合的祖宗类，Collection集合的功能是一切集合都可以直接使用的。
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> set = new HashSet<>();
        System.out.println(set.add("123"));
        System.out.println(set.add("123"));
        System.out.println(set.add("1234"));
        System.out.println(set.add("1235"));
        System.out.println(set);

        //集合转成数组
        Object[] arr1 = set.toArray();
        System.out.println(Arrays.toString(arr1));
        //转换成确定类型的
        String[] arr2 = set.toArray(new String[set.size()]);
        //String[] arrs1 = set.toArray(String[]::new);
        System.out.println(arr2.toString());

        Collection<String> c1 = new ArrayList<>();
        c1.add("李小璐");
        c1.add("马蓉");

        Collection<String> c2 = new ArrayList<>();
        c2.add("白百合");

        c1.addAll(c2); // 把c2集合的元素全部倒入到c1
        System.out.println(c1);


    }
}
