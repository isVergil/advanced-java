package com.javabasic.packagedemo;

/**
 * @ClassName PackageDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 21:57
 * @Version 1.0
 **/
public class Fu {
    //private 只能在本类中访问
    private void otherpackagePrivateMethod() {

    }

    //default 缺省--本类、同一个包下的类中
    void otherpackageDefaultMethod() {

    }

    //protected 本类、其他包下的子类、同一个包下的类中
    protected void otherpackageProtectedMethod() {

    }

    //public 任何地方都可以访问
    public void otherpackagePublicMethod() {

    }

    public static void main(String[] args) {
        Fu fu = new Fu();
        fu.otherpackageDefaultMethod();
        fu.otherpackagePrivateMethod();
        fu.otherpackageProtectedMethod();
        fu.otherpackagePublicMethod();
    }

}

//同一个包子类能访问 default 和 Protected 和  Public
class Zi extends Fu {
    private void test() {
        otherpackageDefaultMethod();
        otherpackageProtectedMethod();
        otherpackagePublicMethod();
    }
}
