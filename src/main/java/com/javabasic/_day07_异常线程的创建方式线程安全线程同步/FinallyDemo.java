package com.javabasic._day07_异常线程的创建方式线程安全线程同步;

/**
 * @ClassName FinallyDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 18:29
 * @Version 1.0
 * 用在捕获处理的异常格式中的，放在最后面。
 * try{
 * // 可能出现异常的代码！
 * }catch(Exception e){
 * e.printStackTrace();
 * }finally{
 * // 无论代码是出现异常还是正常执行，最终一定要执行这里的代码！！
 * }
 * try: 1次。
 * catch：0-N次  (如果有finally那么catch可以没有!!)
 * finally: 0-1次
 * --------------------------------
 * finally的作用: 可以在代码执行完毕以后进行资源的释放操作。
 * 什么是资源？资源都是实现了Closeable接口的，都自带close()关闭方法！！
 * ====================
 * - 运行时异常被抛出可以不处理。可以自动抛出,编译时异常必须处理.按照规范都应该处理!
 * - 重写方法申明抛出的异常，应该与父类被重写方法申明抛出的异常一样或者范围更小
 * - 方法默认都可以自动抛出运行时异常！  throws RuntimeException可以省略不写!!
 * - 当多异常处理时，捕获处理，前边的异常类不能是后边异常类的父类。
 * - 在try/catch后可以追加finally代码块，其中的代码一定会被执行，通常用于资源回收操作。
 **/
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(ffsf()); //"finally"
    }

    public static int ffsf() {
        try {
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");  //必定执行
            return 2; //覆盖前面得return值
        }
    }
}
