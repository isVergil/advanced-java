package com.javabasic._day01_基础知识;

/**
 * @ClassName StaticDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/26 23:53
 * @Version 1.0
 * <p>
 * - 静态。
 * - 修饰方法和变量都是属于类的。没有static修饰的方法和变量是属于每个对象的。
 **/
public class StaticDemo {
    private String name = "fsf";

    public static void main(String[] args) {
        System.out.println(new StaticDemo().name);
    }

}


