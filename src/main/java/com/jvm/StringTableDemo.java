package com.jvm;

/**
 * @ClassName StringTableDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/21 12:50
 * @Version 1.0
 **/

/***
 * 常量池中的信息，都会被加载到运行时常量池中，此时a b都是常量池中的符号，还没变成 java 字符串对象
 * 直到用到这个字符串才开始创建字符串对象放到 StringTable[a,b]中,StringTable是个 hashtable 的结构，不能扩容
 */
public class StringTableDemo {
    public static void main(String[] args) {
        //ldc
        String s1 = "a"; //懒惰
        String s2 = "b";


        //常量字符串拼接
        //去 StringTable 找字符串对象 ab
        //javac 在编译期间的优化，结果已经在编译器确定为 ab
        String s3 = "a" + "b";

        // 调用 StringBuilder 无参构造  使用 append 方法拼接字符串
        // new StringBuilder().append("a").append("b").toString()
        // toString() 相当于 new String()
        String s4 = s1 + s2;

        String s5 = "ab";
        String s6 = s4.intern();
        System.out.println("=================================");
        System.out.println(s3 == s4);    //false
        System.out.println(s3 == s5);    //true
        System.out.println(s3 == s6);    //true

        System.out.println("=================================");
        String x2 = new String("c") + new String("d");
        String x1 = "cd";
        x2.intern();
        System.out.println(x1 == x2);  //false


        //test
        String test1 = new String("AABB");
        //String test1 = new String("AA") + new String("BB");
        test1.intern();
        String test2 = "AABB";
        System.out.println(test1 == test2);
    }
}
