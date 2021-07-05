package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.*;

/**
 * @ClassName TreeSetDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 20:55
 * @Version 1.0
 * TreeSet集合。
 * ---
 * TreeSet: 不重复，无索引，按照大小默认升序排序!!
 * TreeSet集合称为排序不重复集合，可以对元素进行默认的升序排序。
 * -
 * TreeSet集合自自排序的方式：
 * 1.有值特性的元素直接可以升序排序。（浮点型，整型）
 * 2.字符串类型的元素会按照首字符的编号排序。
 * 3.对于自定义的引用数据类型，TreeSet默认无法排序，执行的时候直接报错，因为人家不知道排序规则。
 * -
 * 自定义的引用数据类型的排序实现：
 * 对于自定义的引用数据类型，TreeSet默认无法排序
 * 所以我们需要定制排序的大小规则，程序员定义大小规则的方案有2种：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * -
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * // 如果程序员认为比较者大于被比较者 返回正数！
 * // 如果程序员认为比较者小于被比较者 返回负数！
 * // 如果程序员认为比较者等于被比较者 返回0！
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 * -
 * 小结：
 * TreeSet集合对自定义引用数据类型排序，默认无法进行。
 * 但是有两种方式可以让程序员定义大小规则：
 * a.直接为对象的类实现比较器规则接口Comparable，重写比较方法（拓展方式）
 * b.直接为集合设置比较器Comparator对象,重写比较方法
 * 注意：如果类和集合都带有比较规则，优先使用集合自带的比较规则。
 **/
public class TreeSetDemo {
    public static void main(String[] args) {
        //值类型 自动默认升序
        //字符串类型的元素会按照首字符的编号排序。
        Set<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(90);
        set.add(50);
        set.add(80);
        set.add(60);
        set.add(30);
        set.add(70);
        System.out.println(set);

        //对于自定义的引用数据类型，TreeSet默认无法排序，执行的时候直接报错，因为人家不知道排序规则。
        Set<Apple> apples = new TreeSet<>();
        apples.add(new Apple("1", 1));
        apples.add(new Apple("2", 2));
        apples.add(new Apple("3", 3));
        apples.add(new Apple("4", 4));
        System.out.println(apples);

//        //Apple类中重写的比较方法 ：即在类中实现比较器规则接口Comparable
//        @Override
//        public int compareTo(Apple o) {
//              return this.age-o.age;
//        }


        //为集合设置比较器Comparator对象
        //当类和集合都设置比较时，优先使用集合自带的
//        Set<Apple> apples2 = new TreeSet<>(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                //o1比较者   o2被比较者
//                return o1.getAge() - o2.getAge();
//            }
//        });

        //lambda 表达式写法
        Set<Apple> apples2 = new TreeSet<>((y, x) -> (x.getAge() - y.getAge()));
        apples2.add(new Apple("4", 1));
        apples2.add(new Apple("2", 2));
        apples2.add(new Apple("3", 3));
        apples2.add(new Apple("4", 4));
        System.out.println(apples2);
        //Arrays.asList(apples2).forEach(System.out::println);

    }
}
