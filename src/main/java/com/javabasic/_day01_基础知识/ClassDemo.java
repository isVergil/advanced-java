package com.javabasic._day01_基础知识;

/**
 * @ClassName ClassDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/26 23:31
 * @Version 1.0
 * — 一个Java代码文件中可以定义多个类。但是只能有一个类是用public修饰的，而且public修饰的类名必须成为代码的文件名称。
 * ---------默认访问权限，既不是public，也不是protected，更不是private，与另外一个类处于同一运行包下。引用范围为当前类及当前类同包范围内的其他类可以引用
 * -----类里的五大构成-----
 * -1- 成员变量Field：描述类或者对象的属性信息的。
 * -2- 成员方法Method：描述类或者对象的行为的。
 * -3- 构造器（构造方法,Constructor）: 初始化类的一个对象并返回引用。
 * -4- 代码块：还没有学。
 * -5- 内部类：还没有学。
 * ----------------------
 **/
public class ClassDemo {
    public static void main(String[] args) {
        Student student = new Student();
    }
}

class Student {
    private int x;

    public Student() {
        System.out.println(123);
    }

    public Student(int x) {
        this.x = x;
        System.out.println(3242);

    }

}