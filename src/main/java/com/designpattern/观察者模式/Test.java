package com.designpattern.观察者模式;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/9/5 16:51
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {
        //被观察者
        ConcreteSubject subject = new ConcreteSubject();

        //创建观察者
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        //添加 观察者到 subject
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        //改变subject对象的状态
        subject.set(3000);
        System.out.println("===============状态修改了！");
        //观察者的状态发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        subject.set(600);
        System.out.println("===============状态修改了！");
        //观察者的状态发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        //移除一个订阅者
        subject.deleteObserver(obs2);
        subject.set(100);
        System.out.println("===============状态修改了！");
        //观察者的状态发生了变化
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }
}
