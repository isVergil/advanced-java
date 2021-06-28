package com.javabasic._day02_抽象接口final单例枚举;

/**
 * @ClassName InterfaceMultipleImplementDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/6/27 22:35
 * @Version 1.0
 * 一个类实现多个接口，必须重写完全部接口中的全部抽象方法，否则这个类要定义成抽象类
 **/
public class InterfaceMultipleImplementDemo {
    public static void main(String[] args) {
        BasketBallPlayer yao = new BasketBallPlayer();
        yao.eat();
    }
}

class BasketBallPlayer implements SportMan, Law {

    @Override
    public void rule() {

    }

    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }
}

interface SportsMan {
    void run();

    void competition();
}

interface Law {
    void rule();
}