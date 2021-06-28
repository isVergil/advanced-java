package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName InterfaceMultipleExtendsDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 22:42
 * @Version 1.0
 * ---
 * ---
 * 类与类单继承
 * 类与接口多实现
 * 接口与接口多继承关系，一个接口可以同时继承多个接口
 * ---
 * ---
 * 用一个接口合并多个接口
 **/
public class InterfaceMultipleExtendsDemo {
    public static void main(String[] args) {

    }
}

interface SportWomen extends Laws,Go {
    void run();

    void competition();
}

interface Laws {
    void rules();
}

interface Go {
    void abroad();
}
