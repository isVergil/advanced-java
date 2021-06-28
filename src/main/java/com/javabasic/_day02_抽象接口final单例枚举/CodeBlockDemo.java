package com.javabasic._day02_抽象接口final单例枚举;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CodeBlockDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/28 10:57
 * @Version 1.0
 * ----静态代码块
 * -------必须用static修饰，属于类，会与类一起加载，而且自动触发执行一次
 * -------用于在执行类的方法之前进行静态资源的初始化操作
 * ----实例代码块
 * -------必须无static修饰，属于类的每个对象，会与类的每个对象一起加载，
 * -------实例代码块可以用于初始化实例资源
 * -------实例代码块的代码实际上是提取到每个构造器中去执行的
 **/
public class CodeBlockDemo {
    public static List<String> card = new ArrayList<>();

    {
        System.out.println("实例代码块");
    }

    public CodeBlockDemo() {
        System.out.println("实例代码块");
    }

    static {
        System.out.println("静态代码块执行");
        card.add("121");
        card.add("535");
    }

    public static void main(String[] args) {
        System.out.println("main 执行");
    }
}
