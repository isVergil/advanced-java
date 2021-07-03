package com.javabasic.packagedemo;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 22:03
 * @Version 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        Fu fu = new Fu();
        fu.otherpackageDefaultMethod();
        fu.otherpackageProtectedMethod();
        fu.otherpackagePublicMethod();
    }
}

//同一个包子类能访问 default 和 Protected 和  Public
class Zi1 extends Fu {
    private void test() {
        otherpackageDefaultMethod();
        otherpackageProtectedMethod();
        otherpackagePublicMethod();
    }
}
