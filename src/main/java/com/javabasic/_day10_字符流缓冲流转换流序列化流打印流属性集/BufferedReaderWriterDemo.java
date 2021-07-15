package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集;

/**
 * @ClassName BufferedReaderWriterDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/15 15:54
 * @Version 1.0
 **/

import java.io.*;

/***
 *  目标：字符缓冲输入流的使用。
 *
 *             字节流                                     字符流
 *  字节输入流               字节输出流              字符输入流         字符输出流
 *  InputStream             OutputStream          Reader            Writer   (抽象类)
 *  FileInputStream         FileOutputStream      FileReader        FileWriter(实现类)
 *  BufferedInputStream     BufferedOutputStream  BufferedReader    BufferedWriter(实现类，缓冲流)
 *
 *  字符缓冲输入流：BufferedReader
 *       -- 作用：字符缓冲输入流可以把字符输入流包装成一个高级的缓冲字符输入流，
 *                可以提高字符输入流读数据的性能。
 *       -- 构造器：public BufferedReader(Reader reader):
 *       -- 原理：缓冲字符输入流默认会有一个8K的字符缓冲池,可以提高读字符的性能。
 *       -- 缓冲字符输入流除了提高了字符输入流的读数据性能，
 *          缓冲字符输入流还多了一个按照行读取数据的功能（重点）:
 *              public String readLine(): 读取一行数据返回，读取完毕返回null;
 *      小结：
 *         字符缓冲输入流可以把字符输入流包装成一个高级的缓冲字符输入流，
 *         可以提高字符输入流读数据的性能。
 *         除此之外多了一个按照行读取数据的功能：
 *             public String readLine(): 读取一行数据返回，读取完毕返回null;
 *
 *  字符缓冲输出流：BufferedWriter
 *     -- 作用：把字符输出流包装成一个高级的缓冲字符输出流，提高写字符数据的性能。
 *     -- 构造器：public BufferedWriter(Writer writer):
 *     -- 原理：高级的字符缓冲输出流多了一个8k的字符缓冲池，写数据性能极大提高了!
 *     -- 字符缓冲输出流除了提高字符输出流写数据的性能，还多了一个换行的特有功能：
 *                  public void newLine()：新建一行。
 *      小结：
 *         缓冲字符输出流可以把低级的字符输出流进行包装。提高了写字符的性能。
 *         多了一个换行的功能：public void newLine()：新建一行。
 *
 */
public class BufferedReaderWriterDemo {
    public static void main(String[] args) throws Exception {
        //------------------------------------------------BufferedReader
        // 1.定义一个原始的字符输入流读取源文件
        Reader fr = new FileReader("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\BufferedReaderWriterDemo.java");

        // 3.把低级的字符输入流管道包装成一个高级的缓冲字符输入流管道
        BufferedReader br = new BufferedReader(fr);
        // 定义一个字符串变量存储每行数据
        String line;
        // 使用一个循环读取数据(经典代码)

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

//        // 2.定义一个字符数组循环读取
//        char[] buffer = new char[1024];
//        int len ;
//        while((len = br.read(buffer))!=-1){
//            System.out.println(new String(buffer , 0 , len));
//        }

        br.close();


        //------------------------------------------------BufferedWriter
        // 1.定义一个低级的字符输出流写数据出去
        Writer fw = new FileWriter("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\text01.txt", true);

        // 3.把低级的字符输出流包装成高级的缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(fw);

        //2.写字符输出
        bw.write("我在黑马学IO流~~~~");
        bw.newLine(); // 换行
        bw.write("我在黑马学IO流~~~~");
        bw.newLine();// 换行

        bw.close();
    }
}
