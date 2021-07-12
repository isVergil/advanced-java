package com.javabasic._day09_方法引用Stream流File类递归字节流.IO流;

/**
 * @ClassName FileInputStreamDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/12 14:41
 * @Version 1.0
 **/

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;

/***
 * 目标：IO流读写数据。
 *
 *     IO输入输出流：输入/输出流。
 *         Input:输入。
 *         Output:输出。
 *
 *     引入：
 *         File类只能操作文件对象本身，不能读写文件对象的内容。
 *         读写数据内容，应该使用IO流。
 *
 *     IO流是一个水流模型：IO理解成水管，把数据理解成水流。
 *
 *     IO流的分类:
 *         按照流的方向分为：输入流，输出流。
 *            （1）输出流：以内存为基准，把内存中的数据写出到磁盘文件或者网络介质中去的流称为输出流。
 *                    输出流的作用：写数据到文件，或者写数据发送给别人。
 *
 *            （2）输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据读入到内存中去的流称为输入流。
 *                    输入流的作用：读取数据到内存。
 *
 *         按照流的内容分为: 字节流，字符流。
 *            （1）字节流：流中的数据的最小单位是一个一个的字节，这个流就是字节流。
 *            （2）字符流：流中的数据的最小单位是一个一个的字符，这个流就是字符流。(针对于文本内容)
 *
 *     所以流大体分为四大类:
 *         字节输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字节的形式读入到内存中去的流称为字节输入流。
 *         字节输出流：以内存为基准，把内存中的数据以一个一个的字节写出到磁盘文件或者网络介质中去的流称为字节输出流。
 *         字符输入流：以内存为基准，把磁盘文件中的数据或者网络中的数据以一个一个的字符的形式读入到内存中去的流称为字符输入流。
 *         字符输出流：以内存为基准，把内存中的数据以一个一个的字符写出到磁盘文件或者网络介质中去的流称为字符输出流。
 *     小结：
 *         IO流是读写传输数据的，IO流有很多种，每种流有自己的功能特点。
 *
 * IO流的体系：
 *             字节流                                   字符流
 *     字节输入流           字节输出流               字符输入流      字符输出流
 *     InputStream         OutputStream           Reader         Writer     (抽象类)
 *     FileInputStream     FileOutputStream       FileReader     FileWriter (子类实现类)
 *
 *     a.FileInputStream文件字节输入流。
 *         -- 作用：以内存为基准，把磁盘文件中的数据按照字节的形式读入到内存中的流。
 *                 简单来说，就是按照字节读取文件数据到内存。
 *         -- 构造器：
 *            1.public FileInputStream(File path):创建一个字节输入流管道与源文件对象接通。
 *            2.public FileInputStream(String pathName):创建一个字节输入流管道与文件路径对接。
 *         -- 方法：
 *            1.public int read():每次读取一个字节返回！读取完毕会返回-1。
 *            2.public int read(byte[] buffer):从字节输入流中读取字节到字节数组中去，
 *                 返回读取的字节数量，没有字节可读返回-1。
 *
 *         小结：
 *             一个一个字节读取英文和数字没有问题。
 *             但是一旦读取中文输出无法避免乱码，因为会截断中文的字节。
 *             一个一个字节的读取数据，性能也较差，所以禁止使用此方案！
 *             public int read(byte[] buffer):从字节输入流中读取字节到字节数组中去，
 *                 返回读取的字节数量，没有字节可读返回-1。
 *                      使用字节数组读取内容，效率可以。
 *                      但是使用字节数组读取文本内容输出，也无法避免中文读取输出乱码的问题。
 *
 * ---------拓展：解决字节输入流读取中文内容输出乱码的问题。---------------------
 *
 *     引入：
 *         一个一个字节读取中文输出
 *         一个一个字节数组读取中文输出均无法避免乱码。
 *     如何实现读取可以避免乱码呢？
 *         1.定义一个字节数组与文件的大小刚刚一样大，然后一桶水读取全部字节数据再输出！
 *     小结：
 *         定义一个字节数组与文件的大小刚刚一样大，然后一桶水读取全部字节数据再输出！
 *         可以避免中文读取输出乱码，但是如果读取的文件过大，会出现内存溢出！！
 *
 *         字节流并不适合读取文本文件内容输出，读写文件内容建议使用字符流。
 *
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws Exception {
        // 1.创建文件对象定位dlei01.txt
        File file = new File("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text1.txt");
        // 2.创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream(file);
        // 3.读取一个字节的编号返回，读取完毕返回-1
//        int code1 = is.read(); // 读取一滴水，一个字节
//        System.out.println((char)code1);
//
//        int code2 = is.read(); // 读取一滴水，一个字节
//        System.out.println((char)code2);
//
//        int code3 = is.read(); // 读取一滴水，一个字节
//        System.out.println((char)code3);
//
//        int code4 = is.read(); // 读取一滴水，一个字节 ,读取没有字节返回-1
//        System.out.println(code4);

        // 4.使用while读取字节数
        // 定义一个整数变量存储字节
        int ch = 0;
        while ((ch = is.read()) != -1) {
            System.out.print((char) ch);
        }


        // 需求：读取文件中的数据输出。
        // 1.创建一个文件对象
        //File srcFile = new File("Day09Demo/src/dlei02.txt");
        // 2.创建一个字节输入流管道与源文件对象接通。
        //InputStream is = new FileInputStream(srcFile);

        // 3.简化写法：直接创建一个字节输入流管道与源文件路径接通。
        InputStream is2 = new FileInputStream("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text1.txt");

//        // 4.定义一个字节数组读取数据（定义一个桶）
//        byte[] buffer = new byte[3];
//        // 从is管道中读取字节装入到字节数组中去，返回读取字节的数量。
//        int len = is.read(buffer);
//        System.out.println("读取了字节数："+len);
//        String rs = new String(buffer);
//        System.out.println(rs); // abc
//
//        int len1 = is.read(buffer);
//        System.out.println("读取了字节数："+len1);
//        String rs1 = new String(buffer);
//        System.out.println(rs1); // xyz
//
//        int len2 = is.read(buffer);
//        System.out.println("读取了字节数："+len2);
//        // 倒出字节数组中的全部字符
//        //String rs2 = new String(buffer);
//        // 读取了多少就倒出多少！
//        String rs2 = new String(buffer, 0 , len2);
//        System.out.println(rs2); // iyz
//
//        int len3 = is.read(buffer);
//        System.out.println("读取了字节数："+len3); // -1 数据没有了返回-1


        // 读法优化，必须使用循环     // abc xyz i
        // a.定义一个字节数组代表桶   // ooo ooo o
        byte[] buffer = new byte[3];
        int len; // 存储每次读取的字节数。
        while ((len = is2.read(buffer)) != -1) {
            // 读取了多少就倒出多少！
            String rs = new String(buffer, 0, len);
            System.out.print(rs);
        }

        //解决中文乱码  原因：读取时截断了中文流导致乱码
        // 0.定位文件对象
        File f = new File("src\\main\\java\\com\\javabasic\\_day09_方法引用Stream流File类递归字节流\\text1.txt");
        // 1.定义一个字节输入流通向源文件路径，简化写法！
        InputStream is3 = new FileInputStream(f);

        // 2.定义一个字节数组与文件的大小刚刚一样大
//        System.out.println("文件大小："+f.length());
//        byte[] buffer = new byte[(int) f.length()];
//        int len = is.read(buffer);
//        System.out.println("读取了："+len);
//        String rs = new String(buffer);
//        System.out.println(rs);

        //jDK 1.9 开始
        //byte[] buffers = is3.readAllBytes();
        byte[] buffers = new byte[(int) f.length()];
        String rs = new String(buffers);
        System.out.println(rs);

    }
}
