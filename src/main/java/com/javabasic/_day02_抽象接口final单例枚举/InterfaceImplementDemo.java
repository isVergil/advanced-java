package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName InterfaceImplementDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 21:52
 * @Version 1.0
 * -
 * 实现类实现接口，实现类可以实现多个接口
 * 实现类加上 abstract 就不用实现接口所有方法
 **/
public class InterfaceImplementDemo {
    public static void main(String[] args) {
        PingPongMan pingPongMan = new PingPongMan("张继科");
        pingPongMan.run();
    }
}

class PingPongMan implements SportMan {
    private String name;

    PingPongMan(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "pingpangrun");
    }

    @Override
    public void eat() {
        System.out.println(name + "pingpangeat");
    }
}

interface SportMan {
    String name="23423";

    void run();

    void eat();
}
