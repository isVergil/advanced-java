package com.designpattern.观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * @ClassName ObserverA
 * @Description 具体观察者 、订阅者
 * @Author bill
 * @Date 2022/9/5 16:49
 * @Version 1.0
 **/
public class ObserverA implements Observer {

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }

    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject) o).getState();
    }
}
