package com.javabasic._day07_异常线程的创建方式线程安全线程同步;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ExceptionDemo1
 * @Description TODO
 * @Author bill
 * @Date 2021/7/8 16:32
 * @Version 1.0
 * 目标：异常的产生默认的处理过程解析。(自动处理的过程！)
 * （1）默认会在出现异常的代码那里自动的创建一个异常对象：ArithmeticException。
 * （2）异常会从方法中出现的点这里抛出给调用者，调用者最终抛出给JVM虚拟机。
 * （3）虚拟机接收到异常对象后，先在控制台直接输出异常栈信息数据。
 * （4）直接从当前执行的异常点干掉当前程序。
 * （5）后续代码没有机会执行了，因为程序已经死亡。
 * -----
 * 小结：
 * 异常一旦出现，会自动创建异常对象，最终抛出给虚拟机，虚拟机
 * 只要收到异常，就直接输出异常信息，干掉程序！！
 * -----
 * 默认的异常处理机制并不好，一旦真的出现异常，程序立即死亡！
 * =======================================================================
 * 目标：编译时异常的处理方式。
 * 自己捕获异常和处理异常的格式：捕获处理
 * try{
 * // 监视可能出现异常的代码！
 * }catch(异常类型1 变量){
 * // 处理异常
 * }catch(异常类型2 变量){
 * // 处理异常
 * }...
 * --------------
 * 监视捕获处理异常企业级写法：
 * try{
 * // 可能出现异常的代码！
 * }catch (Exception e){
 * ----e.printStackTrace(); // 直接打印异常栈信息
 * }
 **/
public class ExceptionDemo1 {
    public static void main(String[] args) {

    }
    public static void parseDate(String time)  {
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse(time);
            System.out.println(d);

            InputStream is = new FileInputStream("D:/meinv.png");
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常栈信息
        }
    }

    // JDK 1.7之后
//    public static void parseDate(String time)  {
//        try{
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            Date d = sdf.parse(time);
//            System.out.println(d);
//
//            InputStream is = new FileInputStream("D:/meinv.png");
//        } catch (FileNotFoundException|ParseException e) {
//            e.printStackTrace(); // 打印异常栈信息
//        }
//    }
}
