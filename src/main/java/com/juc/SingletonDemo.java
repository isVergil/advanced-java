package com.juc;

/**
 * @ClassName SingletonDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/25 19:53
 * @Version 1.0
 **/
/*
https://blog.csdn.net/mnb65482/article/details/80458571
单例模式：
---确保一个类只有一个实例,
---而且自行实例化
---并向整个系统提供这个实例
---根据对象实例化时机不同可以分为饿汉式和懒汉式

1、懒汉式
----顾名思义就是实例在用到的时候才去创建，“比较懒”，用的时候才去检查有没有实例，如果有则返回，没有则新建。
----有线程安全和线程不安全两种写法，区别就是synchronized关键字。

2、饿汉式  OOM 内存溢出
----从名字上也很好理解，就是“比较勤”，实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。
----好处是没有线程安全的问题，坏处是浪费内存空间。

3、双检锁DCL（Double Check Lock）--- 在加锁前后做了两次判断
----又叫双重校验锁，综合了懒汉式和饿汉式两者的优缺点整合而成。
----特点是在synchronized关键字内外都加了一层 if 条件判断，这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
----再加上 volatile 防止指令重排
----singleton = new Singleton() 可以拆解为3步：1、分配内存，2、初始化对象，3、指向刚分配的地址，
----若发生重排序，假设 A 线程执行了1和3，还没有执行2，B线程来到判断 NULL，B线程就会直接返回还没初始化的instance了。volatile 可以避免重排序。

4、静态内部类
----静态内部类的方式效果类似双检锁，但实现更简单。但这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
----外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
----SingleTon第一次被加载时，并不需要去加载SingleTonHoler，只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE,
----第一次调用getInstance()方法会导致虚拟机加载SingleTonHoler类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
----缺点：无法传参

5、枚举类
----枚举类相当于多例设计模式
----static final 修饰 不可重写

 */
public class SingletonDemo {

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                SingletonDemo5.INSTANCE.method();
            }).start();
        }
    }

}

//懒汉式
class SingletonDemo1 {
    private static SingletonDemo1 instance;

    private SingletonDemo1() {
        System.out.println("懒汉式-构造方法");
    }

    public synchronized static SingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo1();
        }
        return instance;
    }
}

//饿汉式
class SingletonDemo2 {
    private static SingletonDemo2 singleton = new SingletonDemo2();

    private SingletonDemo2() {
        System.out.println("饿汉式-构造方法");
    }

    public static SingletonDemo2 getInstance() {
        return singleton;
    }
}

//DCL模式
class SingletonDemo3 {
    private static SingletonDemo3 instance = null;

    private SingletonDemo3() {
        System.out.println("DCL模式-构造方法");
    }

    public static SingletonDemo3 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo3.class) {
                if (instance == null) {
                    instance = new SingletonDemo3();
                }
            }
        }
        return instance;
    }
}

//静态内部类
class SingletonDemo4 {
    private static class SingletonHolder {
        private static final SingletonDemo4 INSTANCE = new SingletonDemo4();
    }

    private SingletonDemo4() {
        System.out.println("静态内部类-构造方法");
    }

    public static final SingletonDemo4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

//枚举创建单例
enum SingletonDemo5 {
    INSTANCE;

    public void method() {
        System.out.println("枚举-构造方法");
    }

}
