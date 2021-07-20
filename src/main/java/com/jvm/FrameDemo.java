package com.jvm;

/**
 * @ClassName FrameDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/20 15:07
 * @Version 1.0
 **/
public class FrameDemo {
    public static void main(String[] args) {
        method1(1);
    }

    private static void method1(int i) {
        method2(i);
    }

    private static void method2(int i) {
        System.out.println(i);
    }
}
