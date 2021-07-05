package com.javabasic._day05_迭代器数据结构ListSetTreeSet集合Collections工具类;

import java.util.Arrays;

/**
 * @ClassName VariableParameters
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 22:15
 * @Version 1.0
 * 目标：可变参数。
 * <p>
 * 可变参数用在形参中可以接收多个数据。
 * 可变参数的格式：数据类型... 参数名称
 * <p>
 * 可变参数的作用：
 * 传输参数非常灵活，方便。
 * 可以不传输参数。
 * 可以传输一个参数。
 * 可以传输多个参数。
 * 可以传输一个数组。
 * <p>
 * 可变参数在方法内部本质上就是一个数组。
 * 可变参数的注意事项：
 * 1.一个形参列表中可变参数只能有一个！！
 * 2.可变参数必须放在形参列表的最后面！！
 * 小结：
 * 可变参数的作用：传输参数非常灵活，方便。
 * 可变参数的注意事项：
 * 1.一个形参列表中可变参数只能有一个！！
 * 2.可变参数必须放在形参列表的最后面！！
 **/
public class VariableParameters {
    public static void main(String[] args) {
        test();// 可以不传输参数。
        test("1");// 可以传输一个参数。
        test("1", "2", "1", "2", "1", "2", "1", "2");// 可以传输多个参数。
        test(new String[]{"1", "2", "1", "2", "1", "2", "1", "2"});// 可以传输一个数组。

    }

    //可变参数在方法内部本质上就是一个数组
    //一个形参列表中可变参数只能有一个！！
    //可变参数必须放在形参列表的最后面！！
    public static void test(String... args) {
//        for (String arg : args) {
//            System.out.println(arg);
//        }
        System.out.println(Arrays.toString(args));
    }
}
