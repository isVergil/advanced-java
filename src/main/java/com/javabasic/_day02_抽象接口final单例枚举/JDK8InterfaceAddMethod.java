package com.javabasic._day02_抽象接口final单例枚举;


import javax.lang.model.element.AnnotationMirror;

/**
 * @ClassName JDK8InterfaceAddMethod
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 22:47
 * @Version 1.0
 * JDK 1.8 开始之后接口新增的三个方法（了解即可）（Lambda StreamDemo 函数式接口 中会用到）
 * -
 * -
 * -JDK 1.8 之前 接口只能是抽象方法和常量
 * -
 * -JDK 1.8 之后 接口新增了三个方法
 * -1、默认方法-就是实例方法，
 * --------必须用 default 修饰，
 * --------默认会加 public 修饰,
 * --------只能用接口实现类的对象来调用
 * -2、静态方法
 * --------可以直接加 static 修饰，
 * --------默认会加 public 修饰,
 * --------只能用接口的类名称调用,子类不能调用
 * -3、私有方法 (jdk1.9开始支持) 只能再本接口中访问
 * --------就是私有的实例方法 必须加 private
 * --------通常是给私有方法或者给默认方法调用的
 * --------这里安装的 jdk8 不支持
 * -
 * -
 * -tips
 * -1、当一个类，既继承一个父类，又实现若干个接口时，父类中的成员方法与接口中的默认方法重名，子类就近选择执行父类的成员方法。
 **/
public class JDK8InterfaceAddMethod {
    public static void main(String[] args) {
        Basketball basketball = new Basketball();
        basketball.run();
        Test.eat();
        System.out.println();
        Cat cat = new Cat();
        cat.run();
    }
}

class Basketball implements Test {


}

interface Test {
    //1、默认方法 属于对象的方法 要加default 只能用接口实现类的对象来调用
    default void run() {
        System.out.println("default run");
    }

    //2、静态方法 只能用接口的类名称调用
    static void eat() {
        System.out.println("fsf");
    }

    //3、私有方法 就是私有的实例方法 必须加 private
    //private void go() {

    //}
}

class Cat extends Animal implements Interface1, Interface2 {

    @Override
    public void run() {

    }
}

class Animal {

}

interface Interface1 {
    default void run() {
        System.out.println("Interface1 - run");
    }
}

interface Interface2 {
    default void run() {
        System.out.println("Interface2 - run");
    }
}




