package com.javabasic._day01_基础知识;

/**
 * @ClassName ExtendsDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 13:14
 * @Version 1.0
 * 就是子类继承父类的属性和行为，使得子类对象可以直接具有与父类相同的属性、相同的行为。
 * 子类可以直接访问父类中的非私有的属性和行为。
 * 1. 提高**代码的复用性**（减少代码冗余，相同代码重复利用）。
 * 2. 使类与类之间产生了关系。
 * ----------------
 * 注意：
 * 1、子类不能继承父类的构造器，因为子类有自己的构造器。
 * 2、值得注意的是子类可以继承父类的私有成员（成员变量，方法），只是子类无法直接访问而已，可以通过getter/setter方法访问父类的private成员变量。
 * ---------------但是可以用反射来访问私有
 * 3、子类是不能继承父类的静态成员，子类只是可以访问父类的静态成员，其只有一份可以被子类共享访问（只是共享，并非继承）
 * -
 * -
 * 继承后成员变量访问特点：就近原则
 * ---name        局部变量
 * ---this.name   当前类的成员name
 * ---super.name  父类的name
 * -
 * -
 * 继承后成员方法访问特点：子类有就找子类，没有就找父类，父类没有就报错
 * ---name        局部变量
 * ---this.name   当前类的成员name
 * ---super.name  父类的name
 * -
 * -
 * 方法重写
 * ---@Override:注解，重写注解校验！  可读性好，安全，优雅！（建议声明不变，重写实现）
 * ---这个注解标记的方法，就说明这个方法必须是重写父类的方法，否则编译阶段报错。
 * ---建议重写都加上这个注解，一方面可以提高代码的可读性，一方面可以防止重写出错！
 * ---静态方法和私有方法都不可以被重写
 * -
 * -
 * 继承后构造器的特点
 * ---子类构造默认一定会访问父类的无参构造器，再执行子类自己的构造器(子类不管调用的是有参无参)
 * ---子类构造默认第一行 super(); 默认存在，根据参数去匹配调用父类的构造器 现有爹后有儿子
 * -
 * -
 * this 和 super 关键字
 * ---this(,,,);  根据参数匹配访问本类其他构造器  兄弟构造器
 * ---this() 和 super() 必须放在构造器的第一行，否则报错
 * ---所以this() 和 super() 不能同时出现在构造器中
 * -
 * -
 * 继承的特点
 * -单继承    一个类只能继承一个直接父类 不需要类的二义性
 * -多层继承  一个类可以简介继承多个父类（家谱）
 **/
public class ExtendsDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setName("fsfsf");
        teacher.teach();
    }

}

//学生类
class Student1 extends People {

    public void study() {
        System.out.println(getName() + "认真学习！");
    }

    @Override
    public void eat() {
        super.eat();
    }
}

//老师类
class Teacher extends People {
    Teacher() {
        super("fsf", 21);
        System.out.println("子类构造器");
    }

    public void teach() {
        System.out.println(getName() + "老师教学！");
    }

}

//父类
class People {
    private String name;
    private int age;

    public void eat() {
        System.out.println(name + "在吃饭！");
    }

    public People() {
        System.out.println("父类无参构造器");
    }

    public People(String name, int age) {
        System.out.println("父类有参构造器");
        this.name = name;
        this.age = age;
    }

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
}
