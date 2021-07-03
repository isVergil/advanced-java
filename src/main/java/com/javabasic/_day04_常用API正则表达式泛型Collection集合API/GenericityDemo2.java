package com.javabasic._day04_常用API正则表达式泛型Collection集合API;

import java.util.ArrayList;

/**
 * @ClassName GenericityDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/3 23:47
 * @Version 1.0
 * 泛型没有继承关系
 * 通配符：？ 在使用泛型时代表一些类型
 * ---泛型的上下限：(上限)？ extends Car 表示只能是car类型及其子类
 * -------------- (下限)？ super Car 表示只能是car类型及其父类
 * -----
 * -----ETKV 在定义泛型的时候代表一切类型
 **/
public class GenericityDemo2 {
    public static void main(String[] args) {
        ArrayList<BMW> arrayList = new ArrayList<>();
        arrayList.add(new BMW());
        run(arrayList);
    }

    public static void run(ArrayList<? extends Car> arrayList) {

    }
}

class Car {

}

class BMW extends Car {

}

class BENZ extends Car {

}