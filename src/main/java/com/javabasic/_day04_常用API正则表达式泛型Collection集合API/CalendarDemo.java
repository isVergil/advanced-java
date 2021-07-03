package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.util.Calendar;

/**
 * @ClassName CalendarDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 16:25
 * @Version 1.0
 * - 直接创建GregorianCalendar对象；
 * - 通过Calendar的静态方法getInstance()方法获取GregorianCalendar对象【本次课使用】
 **/
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //获取日历某个字段
        System.out.println(calendar.get(Calendar.YEAR));
        //修改日历某个字段
        calendar.set(Calendar.YEAR, 2077);
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_YEAR, 200);
        System.out.println(calendar.getTime());

    }
}
