package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName Enumemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/28 14:47
 * @Version 1.0
 * - 枚举类
 * - 枚举用于做信息标志和信息分类  优雅
 * -- 修饰符 enum 枚举名称{}
 * -----------1、枚举类是 final 修饰的，不能被继承
 * -----------2、枚举类默认继承了枚举类型 java.lang.Enum
 * -----------3、枚举类的第一行罗列的是枚举类的对象，而且是用常量存储的
 * -----------4、枚举类相当于多例设计模式
 * -----------5、枚举类的构造器是私有的
 **/
public class Enumemo {
    public static void main(String[] args) {

    }
}

enum Sex {
    BOY, GIRL;
}

//反编译结果
//public final class Sex extends java.lang.Enum<Sex> {
//    public static final Sex BOY = new Sex();
//    public static final Sex GIRL = new Sex();
//    public static Sex[] values();
//    public static Sex valueOf(java.lang.String);
//    static {};
//}

