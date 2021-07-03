package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

import com.javabasic.packagedemo.Fu;

/**
 * @ClassName PackageDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 21:51
 * @Version 1.0
 * 权限修饰符有四种 ： private ->  缺 省  -> protected -> public ----
 * ---本类中--------   √    ---   √   ----    √    ----  √    ----
 * ---本包其他类中---   ×    ---   √   ----    √    ----  √    ----
 * ---其他包下的类中-   ×    ---   ×   ----    ×    ----  √    ----
 * ---其他包下的子类-   ×    ---   ×   ----    √    ----  √    ----
 **/
public class PackageDemo {
    public static void main(String[] args) {
        Fu fu = new Fu();
        fu.otherpackagePublicMethod();
    }
}

//子类能访问 Protected 和  Public
class Zi extends Fu {
    private void test() {
        otherpackageProtectedMethod();
        otherpackagePublicMethod();
    }
}
