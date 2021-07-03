package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

import javax.lang.model.element.AnnotationMirror;
import java.util.Objects;

/**
 * @ClassName PolymophicDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 14:55
 * @Version 1.0
 * 形式：
 * ----父类类型/接口 变量名 = new 子类构造器/实现类构造器;
 * -
 * -
 * 概念： 同一个类型的对象，执行同一个行为，在不同的状态下会表现出不同的行为特征
 * -
 * -
 * 多态的识别：
 * ---方法调用：编译看左边，运行看右边
 * ---变量调用：编译看左边，运行看左边
 * -
 * -
 * 多态的使用前提：
 * ---1：必须有实现或者继承关系
 * ---2：必须存在父类类型的变量引用子类类型的对象
 * ---3：必须存在方法重写
 * -
 * -
 * 多态的优势：
 * ---1：在多态形势下，右边对象可以实现组件化切换，业务功能也随之改变，便于拓展和维护，可以实现类与类的解耦
 * ---2：传参时候的优势，即父类类型作为方法形参，可以传入一切子类进行方法的调用，更能体现出多态的拓展性和便利
 * -
 * -
 * 多态的劣势
 * ---编译时不能用子类方法
 * ---
 **/
public class PolymophicDemo {
    public static void main(String[] args) {
        Animal cat = new Cat();
        System.out.println(cat.name);
        cat.run();
    }
}

class Cat extends Animal {
    public String name = "Cat";

    @Override
    public void run() {
        System.out.println("cat run");
    }

    public void catmethod() {

    }
}

class Dog extends Animal {
    public String name = "Dog";

    @Override
    public void run() {
        System.out.println("dog run");
    }

    public void dogmethod() {

    }
}

class Animal {
    public String name = "anmial";

    public void run() {
        System.out.println("run");
    }

    Animal() {

    }

    Animal(String name) {
        this.name = name;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Animal) {
//            Animal animal = (Animal) obj;
//            if (animal.name.equals(this.name))
//                return true;
//        }
//        return false;
//    }


    //标准写法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
