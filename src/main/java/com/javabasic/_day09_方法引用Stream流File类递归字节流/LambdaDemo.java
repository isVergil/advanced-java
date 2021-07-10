package com.javabasic._day09_方法引用Stream流File类递归字节流;

/**
 * @ClassName LambdaDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/10 22:13
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/***
 * 目标：Lambda表达式的概述。
 *
 *      什么是Lambda表达式？
 *          Lambda表达式是JDK1.8开始之后的新技术，是一种代码的新语法。
 *          是一种特殊写法，
 *          作用：“核心目的是为了简化匿名内部类的代码写法”。
 *
 *      Lambda表达式的格式:
 *         (匿名内部类被重写方法的形参列表) -> {
 *            被重写方法的方法体代码。
 *         }
 *
 *         -> 就是一个新语法，没有实际含义，但是不能省略！
 *
 *      Lambda表达式的使用前提：
 *          （1）Lambda表达式并不能简化所有匿名内部类的写法。
 *          （2）Lambda表达式只能简化接口中只有一个抽象方法的匿名内部类形式。
 *
 *      Lambda表达式只能简化函数式接口的匿名内部类写法：
 *          a.首先必须是接口。
 *          b.接口中只能有一个抽象方法。
 *      小结：
 *         Lambda表达式只能简化接口中只有一个抽象方法的匿名内部类写法。 @FunctionalInterface
 *         接口中只有一个抽象方法的接口称为函数式接口。
 *         Lambda只能简化函数式接口的匿名内部类写法。
 *
 *     Lambda表达式的省略写法（进一步在Lambda表达式的基础上继续简化）
 *     （1）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写,同时要省略分号！
 *     （2）如果Lambda表达式的方法体代码只有一行代码。可以省略大括号不写。
 *         此时，如果这行代码是return语句，必须省略return不写，同时也必须省略";"不写
 *     （3）参数类型可以省略不写。
 *     （4）如果只有一个参数，参数类型可以省略，同时()也可以省略。
 *
 *    应用：
 *      1、Lambda表达式简化Runnable接口匿名内部类
 *      2、Lambda简化Comparator接口匿名内部类写法
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //1、Lambda表达式简化Runnable接口匿名内部类
        new Thread(() -> System.out.println("fsf")).start();

        //2、Lambda简化Comparator接口匿名内部类写法
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", 1));
        students.add(new Student("2", 2));
        students.add(new Student("3", 3));
        Collections.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
        //遍历
        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });
        //简化
        students.forEach(s -> System.out.println(s));
    }
}

class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
