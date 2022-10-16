package com.designpattern.观察者模式;

import java.util.Observable;

/**
 * @ClassName ConcreteSubject
 * @Description 具体被观察者
 * @Author bill
 * @Date 2022/9/5 16:46
 * @Version 1.0
 **/
public class ConcreteSubject extends Observable {
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;

    public void set(int s) {
        state = s;   //目标对象状态发生改变
        setChanged();  //表示目标对象已经做了更改
        notifyObservers(state);  //通知所有的观察者
    }
}
