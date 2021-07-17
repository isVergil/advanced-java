package com.javabasic._day13_XML和Dom4j装饰模式工厂模式commonsio工具包Base64;

/**
 * @ClassName FactoryPattern
 * @Description TODO
 * @Author bill
 * @Date 2021/7/18 0:03
 * @Version 1.0
 **/
public class FactoryPattern {
    // 生产对象的方法：工厂方法
    public static Animal createAniaml() {
//        Dog dog = new Dog();
//        return dog;
        return new Cat();
    }
}
