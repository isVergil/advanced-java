package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;


import java.util.Date;

/**
 * @ClassName DateDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 22:45
 * @Version 1.0
 **/
public class DateDemo {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.getTime());
        long start = new Date().getTime();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        long end = new Date().getTime();
        System.out.println((end - start) / 1000.0);
    }
}
