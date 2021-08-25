package com.juc.old;

/**
 * @ClassName Frames
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 15:12
 * @Version 1.0
 * 栈帧测试
 **/
public class Frames {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                method1(20);
            }
        };
        t1.setName("t1");
        t1.start();
        method1(10);
    }

    private static void method1(int i) {
        int y = i + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
