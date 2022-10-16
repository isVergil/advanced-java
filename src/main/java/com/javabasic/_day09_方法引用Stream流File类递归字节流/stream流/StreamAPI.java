package com.javabasic._day09_方法引用Stream流File类递归字节流.stream流;

/**
 * @ClassName StreamAPI
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 20:51
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/***
 * 目标：Stream流的常用API
 *      forEach : 逐一处理(遍历)
 *      count：统计个数
 *         -- long count();
 *      filter : 过滤元素
 *         -- StreamDemo<T> filter(Predicate<? super T> predicate)
 *      limit : 取前几个元素
 *      skip : 跳过前几个
 *      map （映射）: 加工方法：把原来的元素加工以后，重新放上去
 *          -- <R> StreamDemo<R> map(Function<? super T, ? extends R> mapper);
 *      concat : 合并流。
 *
 *
 *  目标：终结与非终结方法。
 *
 *     终结方法：一旦Stream调用了终结方法，流的操作就全部终结了，不能继续使用，
 *         只能创建新的Stream操作。
 *         终结方法： foreach , count。
 *
 *     非终结方法：每次调用完成以后返回一个新的流对象,
 *         可以继续使用，支持链式编程！
 */
public class StreamAPI {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        });

        //简化的 @FunctionalInterface 函数式接口
        list.stream().filter(s -> s.length() == 3).filter(s -> s.startsWith("张"))
                .forEach(System.out::println);
        // 统计数量
        long count = list.stream().filter(s -> s.length() == 3)
                .filter(s -> s.startsWith("张")).count();
        System.out.println(count);
        // 取前2个
        list.stream().filter(s -> s.length() == 3).limit(2)
                .forEach(System.out::println);
        // 跳过前2个
        list.stream().filter(s -> s.length() == 3).skip(2)
                .forEach(System.out::println);

        // 需求：把名称都加上“黑马的:+xxx”
        list.stream().map(a -> "黑马的：" + a).forEach(System.out::println);

        // 需求：把名称都加工厂学生对象放上去!!
        // list.stream().map(name -> new Student(name)).forEach(System.out::println);

        list.stream().map(Student::new).forEach(System.out::println);

        // 数组流
        Stream<Integer> s1 = Stream.of(10, 20 ,30 ,40);
        // 集合流
        Stream<String> s2 = list.stream();
        // 合并流
        Stream<Object> s3 = Stream.concat(s1,s2);
        s3.forEach(System.out::println);



        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        /**
         * 1. 第一个队伍只要名字为3个字的成员姓名；
         * 2. 第一个队伍筛选之后只要前3个人；
         */
        Stream<String> oneStream =
                one.stream().filter(s -> s.length() == 3).limit(3);

        /**
         * 3. 第二个队伍只要姓张的成员姓名；
         * 4. 第二个队伍筛选之后不要前2个人；
         * 5. 将两个队伍合并为一个队伍；
         */
        Stream<String> twoStream =
                two.stream().filter(s -> s.startsWith("张")).skip(2);
        Stream<String> allStream = Stream.concat(oneStream , twoStream);

        /**
         * 6. 根据姓名创建`Student`对象； (加工)
         * 7. 打印整个队伍的Student对象信息。
         */
        //allStream.map(s -> new Student(s)).forEach(System.out::println);
        allStream.map(Student::new).forEach(System.out::println);


        List<String> listTest = new ArrayList<>();
        listTest.add("张无忌");
        listTest.add("周芷若");
        listTest.add("赵敏");
        listTest.add("张强");
        listTest.add("张三丰");
        listTest.add("张三丰");

        // foreach终结方法  没有返回值
        listTest.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3).forEach(System.out::println);

        long count1 =  listTest.stream().filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3).count();
        System.out.println(count1);
    }
}

class Student {
    private String name;
    private int age;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
