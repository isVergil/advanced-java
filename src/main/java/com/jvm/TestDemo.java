package com.jvm;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/21 15:06
 * @Version 1.0
 **/
public class TestDemo {
    public static void main(String[] args) {
        String test1 = new String("AABB");                                 //false
        //String test1 = new String("AA") + new String("BB");    //true
        test1.intern();
        String test2 = "AABB";
        System.out.println(test1 == test2);

    }

}
