package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集;

/**
 * @ClassName BufferedStreamDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/13 22:47
 * @Version 1.0
 **/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/***
 *     目标：缓冲流的概述和分类。
 *
 *            字节流                                             字符流
 *     字节输入流               字节输出流                 字符输入流         字符输出流
 *     InputStream             OutputStream             Reader            Writer   (抽象类)
 *     FileInputStream         FileOutputStream         FileReader        FileWriter(实现类,低级流，原始流)
 *     BufferedInputStream     BufferedOutputStream     BufferedReader    BufferedWriter(实现类，缓冲流)
 *
 *     什么是缓冲流：缓冲流可以提高字节流和字符流的读写数据的性能。
 *     缓冲流分为四类：
 *         （1）BufferedInputStream：字节缓冲输入流，可以提高字节输入流读数据的性能。
 *         （2）BufferedOutStream：  字节缓冲输出流，可以提高字节输出流写数据的性能。
 *         （3）BufferedReader：  字符缓冲输入流，可以提高字符输入流读数据的性能。
 *         （4）BufferedWriter：  字符缓冲输出流，可以提高字符输出流写数据的性能。
 *
 *   a.字节缓冲输入流：BufferedInputStream
 *             -- 作用：可以把低级的字节输入流包装成一个高级的缓冲字节输入流管道,
 *                     从而提高字节输入流读数据的性能。
 *             -- 构造器: public BufferedInputStream(InputStream in)
 *             -- 原理：缓冲字节输入流管道自带了一个8KB的缓冲池(在内存里，所以读取快)，每次可以直接借用操作系统的功能最多提取8KB   8192 8000字节
 *                 的数据到缓冲池中去，以后我们直接从缓冲池读取数据，所以性能较好！
 *      小结：
 *          字节缓冲输入流：BufferedInputStream
 *          可以把低级的字节输入流包装成一个高级的缓冲字节输入流管道,从而提高字节输入流读数据的性能。
 *          功能几乎无变化。
 *
 *  b.字节缓冲输出流：BufferedOutputStream
 *          -- 作用：可以把低级的字节输出流包装成一个高级的缓冲字节输出流，从而提高写数据的性能。
 *          -- 构造器：public BufferedOutputStream(OutputStream os)
 *          -- 原理：缓冲字节输出流自带了8KB缓冲池,数据就直接写入到缓冲池中去，性能极高了！
 *      小结：
 *             字节缓冲输出流可以把低级的字节输出流包装成一个高级的缓冲字节输出流，从而提高写数据的性能。
 *             功能几乎不变。
 */
public class BufferedStreamDemo {
    public static void main(String[] args) throws Exception {
        // 1.定义一个低级的字节输入流与源文件接通
        InputStream is = new FileInputStream("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\FileReaderDemo.java");

        // 3.把低级的字节输入流包装成一个高级的缓冲字节输入流。
        BufferedInputStream bis = new BufferedInputStream(is);

        // 2.定义一个字节数组按照循环读取。 可能乱码
        byte[] buffer = new byte[3];
        int len;
        while ((len = bis.read(buffer)) != -1) {
        //while ((len = is.read(buffer)) != -1) {
            String rs = new String(buffer, 0, len);
            System.out.print(rs);
        }
    }
}
