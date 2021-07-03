package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

/**
 * @ClassName PolymophicDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 15:25
 * @Version 1.0
 **/
public class PolymophicDemo2 {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.run();
        //调用 cat.catmethod(); 报错，因为多态不能调子类独有的方法
        //1、解决 强制转换  大类型的转换成小类型的（父类型->子类型）
        Cat tomcat = (Cat) cat;
        tomcat.catmethod();
        //2、强制转换异常，编译时不出错，运行时报错 ClassCastException
        Animal cat1 = new Cat();
        //Dog dog1 = (Dog) cat1; //ClassCastException异常
        //2、解决方法变量 instanceof 类型:判断前面的变量是否是后面的类型或者其子类类型 返回true
        if (cat1 instanceof Cat) {
            Cat cat2 = (Cat) cat1;
            cat2.catmethod();
        }
        if (cat1 instanceof Dog) {
            Dog dog2 = (Dog) cat1;
            dog2.dogmethod();
        }


    }
}

