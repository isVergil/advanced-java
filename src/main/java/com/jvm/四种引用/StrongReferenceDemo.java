package com.jvm.四种引用;

/**
 * @ClassName StrongReferenceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/9/1 21:50
 * @Version 1.0
 **/
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = object1;
        object1 = null;
        System.gc();
        System.out.println(object2);
    }
}
