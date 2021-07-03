package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName SystemDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 16:40
 * @Version 1.0
 * `java.lang.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作。
 * 1、public   static void exit(int status) 终止当前运行的 Java 虚拟机，非零表示异常终止
 * 2、public   static long currentTimeMillis()  返回当前时间(以毫秒为单位)
 * 3、数组拷贝
 * ----arraycopy(Object var0, int var1, Object var2, int var3, int var4);
 * -------参数一：原数组
 * -------参数二：从原数组的哪个位置开始赋值。
 * -------参数三：目标数组
 * -------参数四：赋值到目标数组的哪个位置
 * -------参数五：赋值几个。
 **/
public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("程序开始...");
        //0代表正常终止虚拟机
        //System.exit(0);
        System.out.println(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(System.currentTimeMillis()));
        int[] arr1 = new int[]{0, 1, 2, 3, 4};
        int[] arr2 = new int[5];
        System.arraycopy(arr1, 2, arr2, 1, 3);
        System.out.println(Arrays.toString(arr2));


        System.out.println("程序结束...");


        //定义爬取规则
        String mubiao = "fsfsf";
        String regex = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mubiao);
        while(matcher.find()){
            System.out.println();
        }
    }
}
