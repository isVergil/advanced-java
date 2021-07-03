package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

/**
 * @ClassName InnerClass
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 15:53
 * @Version 1.0
 * 内部类：定义在一个类里面的类就是内部类
 * ------可以提供更好的封装性，内部类有更多的权限修饰符，封装性有更多的控制
 * ------可以体现出组件的思想
 * ---
 * ---1、静态内部类：static 修饰，属于外部类本身，会加载一次
 * ---2、实例内部类（成员内部类）：属于外部类对象，需要用外部类对象一起加载，可以访问外部类的全部成员
 * ---3、局部内部类（没啥用）：定义在方法中，构造器中。代码块中，for循环中定义的内部类
 * ---4、匿名内部类（重点）就是一个没有名字的局部内部类（也是一个对象），可以简化代码
 * ---------------------匿名内部类一旦写出来，就会立即创建一个匿名内部类的对象返回
 * ---------------------匿名内部类的对象类型相当于当前 new 的那个类型的子类类型
 * ---------------------外部类名$1。class  外部类名$1。class 类中第一、二个匿名内部类
 * -
 * -
 * -private 不能修饰外部类
 **/
public class InnerClass {
    public static void main(String[] args) {

        //创建静态内部类
        Outter.StaticInner StaticInner = new Outter.StaticInner();

        //创建实例（成员）内部类  外部类的对象 因此先 new Outter 再 new Inner
        Outter.Inner Inner = new Outter().new Inner();

        //局部内部类 只能定义实例成员，不能定义静态成员
        class LocalClass {

        }

        //匿名内部类  代表了 Cat1 对象 抽象对象被匿名内部类实例化了 多态写法 参考 Cat1 对象
        Animal1 animal = new Animal1() {
            @Override
            void run() {
                System.out.println("猫跑");
            }
        };
        animal.run();
    }
}

//外部类-宿主 内部类-寄生
class Outter {
    //静态内部类
    //属于外部类本身，会加载一次,他的特点与外部类完全一样，只是位置外别人里面而已
    public static class StaticInner {

    }

    //实例内部类 无 static 修饰，属于外部类的对象
    //不能在实例内部类中定义静态成员，其他都可以定义
    //该类无静态区 故 不能定义 static 变量
    //static final 可以定义在其中 因为是存在常量池的，只有一份
    public class Inner {
        public static final String schoolName = "fsf";
    }
}

class Cat1 extends Animal1 {

    @Override
    void run() {

    }
}

abstract class Animal1 {
    abstract void run();

    public void go() {
        System.out.println("go");
    }
}
