package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集;

/**
 * @ClassName FileReaderDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/13 18:27
 * @Version 1.0
 **/

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/***
 * 目标：字符输入流的使用。
 *
 *      IO流的体系：
 *             字节流                                   字符流
 *      字节输入流           字节输出流               字符输入流       字符输出流
 *      InputStream         OutputStream            Reader         Writer     (抽象类)
 *      FileInputStream     FileOutputStream        FileReader     FileWriter (实现类)
 *
 *      c.FileReader:文件字符输入流。
 *          -- 作用：以内存为基准，把磁盘文件的数据以字符的形式读入到内存。
 *             简单来说，读取文本文件内容到内存中去。
 *          -- 构造器：
 *             public FileReader(File file):创建一个字符输入流与源文件对象接通。
 *             public FileReader(String filePath):创建一个字符输入流与源文件路径接通。
 *          -- 方法：
 *             public int read(): 读取一个字符的编号返回！ 读取完毕返回-1
 *             public int read(char[] buffer):读取一个字符数组，读取多少个字符就返回多少个数量，读取完毕返回-1
 *      小结：
 *         字符流一个一个字符的读取文本内容输出，可以解决中文读取输出乱码的问题。
 *         字符流很适合操作文本文件内容。
 *         但是：一个一个字符的读取文本内容性能较差！！
 *
 *         字符流按照字符数组循环读取数据，可以解决中文读取输出乱码的问题，而且性能也较好！！
 */
public class FileReaderDemo {
    public static void main(String[] args) throws Exception {
//        File file = new File("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\text1.txt");
//        Reader reader = new FileReader(file);
        //简化写法
        Reader reader = new FileReader("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\FileReaderDemo.java");
        //按照字符读取，每次读取一个字符的编号
//        int code = -1;
//        while ((code = reader.read()) != -1)
//            System.out.println((char) code);

//        char[] buffer = new char[8];
//        int length = reader.read(buffer);
//        System.out.println("字符串长度" + length);
//        String result = new String(buffer, 0, 8);
//        System.out.println(result);

        char[] buffer = new char[1024];
        int len;
        while ((len = reader.read(buffer)) != -1) {
            //读取多少倒出多少
            System.out.print(new String(buffer, 0, len));
        }


    }
}
