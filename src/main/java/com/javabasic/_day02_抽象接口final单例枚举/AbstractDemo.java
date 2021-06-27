package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName AbstractDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 14:27
 * @Version 1.0
 * -抽象类的作用：为了被子类继承
 * ---抽象类是为了被子类继承，约束子类要重写抽象方法
 * ---一个类继承了抽象类，必须重写完抽象类的全部抽象方法，否则这个类也必须定义成抽象类
 * -
 * -
 * -抽象类的特征 ：有得有失  ：得到了拥有抽象方法的能力，失去了创建对象的能力，类的其他成分都具备
 * ---1. 抽象类不能创建对象，如果创建，编译无法通过而报错。只能创建其非抽象子类的对象。
 * ------理解：假设创建了抽象类的对象，调用抽象的方法，而抽象方法没有具体的方法体，没有意义。
 * ---2. 抽象类中，可以有构造器，是供子类创建对象时，初始化父类成员使用的。
 * ------理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。
 * ---3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
 * ------理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计。
 * ---4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则子类也必须定义成抽象类，编译无法通过而报错。
 * ------理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么创建对象后，调用抽象的方法，没有意义。
 * ---5. 抽象类存在的意义是为了被子类继承，抽象类体现的是模板思想。
 * ------理解：抽象类中已经实现的是模板中确定的成员，抽象类不确定如何实现的定义成抽象方法，交给具体的子类去实现。
 * -
 * -
 * -抽象类存在意义：（模板思想：部分实现，部分抽象）
 * ---1. 抽象类就是为了被子类继承（就是为了派生子类），否则抽象类毫无意义（基本准则）
 * ---2. 抽象类中，一定有且必须有构造器，是供子类创建对象时，初始化父类成员使用的。
 * ------理解：子类的构造方法中，有默认的super()，需要访问父类构造方法。
 * ---3. 抽象类中，不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
 * ------理解：未包含抽象方法的抽象类，目的就是不想让调用者创建该类对象，通常用于某些特殊的类结构设计。
 * ---4. 抽象类的子类，必须重写抽象父类中所有的抽象方法，否则子类也必须定义成抽象类，编译无法通过而报错。
 * ------理解：假设不重写所有抽象方法，则类中可能包含抽象方法。那么
 **/
public class AbstractDemo {
    public static void main(String[] args) {
//        Teacher teacher = new Teacher();
//        teacher.work();
        Student lty = new Student();
        lty.write();
    }

}

class Manager extends Employee {

    @Override
    public void work() {
        System.out.println("班主任需要管理");
    }
}

class Teacher extends Employee {

    @Override
    public void work() {
        System.out.println("老师需要上课");
    }
}

abstract class Employee {
    //子类要完成这个功能，但是由自己重写完成
    //抽象方法：没有方法体，只有方法签名，必须用 abstract 修饰
    //拥有抽象方法的类必须定义成抽象类
    public abstract void work();

    static void test() {
        System.out.println("fs");
    }
}

class Student extends Template {

    @Override
    public String writeMain() {
        return "\t\t\t正文";
    }
}

abstract class Template {
    private String title = "\t\t\t\t\t\t\t\t\t《我的爸爸》";
    private String one = "\t\t\t开头部分内容";
    private String last = "作文结尾";

    public void write() {
        System.out.println(title);
        System.out.println(one);
        //正文用抽象方法来写
        System.out.println(writeMain());
        System.out.println(last);
    }

    public abstract String writeMain();
}
