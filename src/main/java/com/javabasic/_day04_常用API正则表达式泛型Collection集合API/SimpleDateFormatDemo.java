package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SimpleDateFormatDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 15:08
 * @Version 1.0
 * - `public String format(Date date)`：将Date对象格式化为字符串。
 * - `public String format(Object time)`：将Date对象格式化为字符串。（可以传时间毫秒值）
 * - `public Date parse(String date)`：将字符串解析为Date对象。 throws ParseException 格式一样否则报错
 **/
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        //日期格式转换
        Date d = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        System.out.println(simpleDateFormat.format(d));

        //String解析成日期 记得捕捉 ParseException 异常
        String date = "2021年07月04日";
        try {
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日");
            System.out.println(simpleDateFormat1.format(simpleDateFormat1.parse(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Object 类型转换成字符串
        long time = new Date().getTime() + (1000); //当前时间+1s
        System.out.println(simpleDateFormat.format(time));

    }
}
