package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName SingleInstanceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/28 11:43
 * @Version 1.0
 **/
public class SingleInstanceDemo {
    public static void main(String[] args) {
        System.out.println(SingleIntance01.getInstance());
    }
}

//饿汉单例模式
class SingleIntance01 {
    //1、把类的构造器私有，构造器只能在本类中访问
    private SingleIntance01() {

    }

    //2、在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static SingleIntance01 ins = new SingleIntance01();


    //3、定义一个静态方法返回这个唯一对象。
    public static SingleIntance01 getInstance() {
        return ins;
    }
}

//懒汉单例模式
class SingleIntance02 {
    //1、把类的构造器私有，构造器只能在本类中访问
    private SingleIntance02() {

    }

    //2、在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static SingleIntance02 ins;

    //3、定义一个静态方法返回这个唯一对象 ，第一次不存在对象才创建返回
    public static SingleIntance02 getInstance() {
        if (ins == null) {
            ins = new SingleIntance02();
        }
        return ins;
    }
}