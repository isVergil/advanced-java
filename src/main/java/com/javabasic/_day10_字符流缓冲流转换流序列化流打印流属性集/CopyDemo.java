package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集;

/**
 * @ClassName CopyDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/15 15:21
 * @Version 1.0
 **/

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/***
 * 目标：利用字节流的复制统计各种写法形式下缓冲流的性能执行情况。
 *
 *     复制流：
 *         （1）使用低级的字节流按照一个一个字节的形式复制文件。
 *         （2）使用低级的字节流按照一个一个字节数组的形式复制文件。
 *         （3）使用高级的缓冲字节流按照一个一个字节的形式复制文件。
 *         （4）使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。
 *
 *     源文件：D:\学习资料\java进阶13天资料\SEKIRO  SHADOWS DIE TWICE 2021.01.09 - 22.46.17.04.mp4
 *     目标文件：D:\学习资料\java进阶13天资料\output\
 *
 *     小结：
 *         高级的字节缓冲流按照一个一个字节数组的形式复制性能极高，建议以后使用！
 */
public class CopyDemo {
    public static final String SRC_FILE = "D:\\学习资料\\java进阶13天资料\\SEKIRO  SHADOWS DIE TWICE 2021.01.09 - 22.46.17.04.mp4";
    public static final String DEST_FIlE = "D:\\学习资料\\java进阶13天资料\\output\\";

    public static void main(String[] args) {
        //copy01();   //低级流一个一个字节复制，速度太慢，直接淘汰
        copy02();   //低级的字节流按照一个一个字节数组的形式复制 ,读取较慢  0.911
        copy03();   //高级的缓冲字节流按照一个一个字节的形式复制 ,读取较慢   4.078
        copy04();   //高级的字节缓冲流按照一个一个字节数组的形式复制,速度极快   0.216
    }

    //（1）使用低级的字节流按照一个一个字节的形式复制文件。
    public static void copy01() {
        long startTimer = System.currentTimeMillis();
        try (
                //创建一个低级的字节输入流与源文件联通
                InputStream inputStream = new FileInputStream(SRC_FILE);
                //创建一个低级的字节输出流管道与目标文件联通
                OutputStream outputStream = new FileOutputStream(DEST_FIlE + "copy01.mp4");
        ) {
            //定义一个整形变量存储读取的字节
            int ch = 0;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("-------使用低级的字节流按照一个一个字节的形式复制文件。" + (endTimer - startTimer) / 1000.0);
    }

    //（2）使用低级的字节流按照一个一个字节数组的形式复制文件。
    public static void copy02() {
        long startTimer = System.currentTimeMillis();
        try (
                //创建一个低级的字节输入流与源文件联通
                InputStream inputStream = new FileInputStream(SRC_FILE);
                //创建一个低级的字节输出流管道与目标文件联通
                OutputStream outputStream = new FileOutputStream(DEST_FIlE + "copy02.mp4");
        ) {
            //定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            //定义一个变量存储每次读取的字节数量
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("-------使用低级的字节流按照一个一个字节数组的形式复制文件。" + (endTimer - startTimer) / 1000.0);
    }

    //（3）使用高级的缓冲字节流按照一个一个字节的形式复制文件。
    public static void copy03() {
        long startTimer = System.currentTimeMillis();
        try (
                //创建一个低级的字节输入流与源文件联通
                InputStream inputStream = new FileInputStream(SRC_FILE);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                //创建一个低级的字节输出流管道与目标文件联通
                OutputStream outputStream = new FileOutputStream(DEST_FIlE + "copy03.mp4");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            //定义一个整形变量存储读取的字节
            int ch = 0;
            while ((ch = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("-------使用高级的缓冲字节流按照一个一个字节的形式复制文件。" + (endTimer - startTimer) / 1000.0);
    }

    //（4）使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。
    public static void copy04() {
        long startTimer = System.currentTimeMillis();
        try (
                //创建一个低级的字节输入流与源文件联通
                InputStream inputStream = new FileInputStream(SRC_FILE);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                //创建一个低级的字节输出流管道与目标文件联通
                OutputStream outputStream = new FileOutputStream(DEST_FIlE + "copy04.mp4");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        ) {
            //定义一个字节数组存储字节
            byte[] buffer = new byte[1024];
            //定义一个变量存储每次读取的字节数量
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("-------使用高级的缓冲字节流按照一个一个字节数组的形式复制文件。" + (endTimer - startTimer) / 1000.0);
    }
}
