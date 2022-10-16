package com.test;

/**
 * @ClassName Test111111
 * @Description TODO
 * @Author bill
 * @Date 2022/8/15 18:59
 * @Version 1.0
 **/
public class Test111111 {

    public static void main(String[] args) {
        func1("1", 1);
    }

    public static int func1(int... oo) {
        System.out.println(0);
        return 0;
    }

    public static int func1(String a, int... oo) {
        System.out.println(1);
        return 1;
    }
}

interface father {
    default void fun2() {
        System.out.println(1);
    }
}

interface father1 {
    static int fff = 1;
}

interface father2 {
    static int fff = 1;
}

interface son extends father, father1, father2 {

}
