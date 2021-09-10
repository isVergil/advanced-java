package com.internship.bytedance;

/**
 * @ClassName SingletonDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/9/6 16:17
 * @Version 1.0
 **/
//单例模式 5 种
public class SingletonDemo {
}

//1、懒汉 实例在需要时才会创建
class Singleton1 {

    private static Singleton1 instance;

    //加上 synchronized 以保证安全性
    public static synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }

    Singleton1() {

    }
}

//2、饿汉 实例化之前就已经创建好了
class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    //加上 synchronized 以保证安全性
    public static Singleton2 getInstance() {
        return instance;
    }

    Singleton2() {

    }
}

//3、双检锁模式 在懒汉基础上保证线程安全
class Singleton3 {

    private volatile static Singleton3 instance = null;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

    Singleton3() {

    }
}

//4、静态内部类
class Singleton4 {

    private static class SingletonHolder {
        private static Singleton4 instance = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonHolder.instance;
    }

    Singleton4() {

    }
}
