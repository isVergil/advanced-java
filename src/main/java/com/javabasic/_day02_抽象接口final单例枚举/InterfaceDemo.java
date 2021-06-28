package com.javabasic._day02_抽象接口final单例枚举;

import java.sql.Connection;

/**
 * @author bill
 * @description todo
 * @updateTime 2021/6/27  21:34
 * 接口体现的是规范思想
 * --- 接口是更加彻底的抽象，接口中全部是抽象方法。
 * -
 * --- JDK 1.8之前，接口中只能是抽象方法和常量
 * -
 * --- 接口中的抽象方法可以省略  public abstract 不写，默认会加上
 * --- 接口中的常量 public static final 不写，默认会加上
 * --- 除此之外没有其他成分
 */
public interface InterfaceDemo {
    //1 抽象方法
    //接口中的抽象方法可以省略 public abstract 不写，默认会加上
    void run();

    //2 常量 ：变量值只有一个，而且在程序运行过程中不能更改
    //public static final 修饰 缺一不可
    //常量的变量名称建议字母全部大写，多个单词用 _ 连接
    //可以省略 public static final 不写
    public static final String SCHOOL_NAME = "黑马";
    String STUDENT_NAME = "黑马";


}
