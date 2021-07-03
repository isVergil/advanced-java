package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

/**
 * @ClassName RegexDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 22:09
 * @Version 1.0
 * String类的split()
 * String类的replaceAll()
 **/
public class RegexDemo {
    public static void main(String[] args) {
        System.out.println(checkQQ("32425345"));
    }

    //用正则表达式
    public static boolean checkQQRegex(String qq) {
        return qq.matches("\\d{4,}");
    }

    //不用正则表达式
    public static boolean checkQQ(String QQ) {
        if (QQ == null) return false;
        if (QQ.length() >= 4) {
            boolean result = true;//默认合法
            for (int i = 0; i < QQ.length(); i++) {
                char cha = QQ.charAt(i);
                if (cha < '0' || cha > '9')
                    result = false;
            }
            return result;
        } else {
            return false;
        }
    }
}
