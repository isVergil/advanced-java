package com.javabasic._day10_字符流缓冲流转换流序列化流打印流属性集;

/**
 * @ClassName PrintStreamDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/15 16:41
 * @Version 1.0
 **/

import java.io.FileNotFoundException;
import java.io.PrintStream;

/***
 * 目标：打印流PrintStream / PrintWriter.
 *
 *     打印流的作用：
 *         1.可以方便，快速的写数据出去。
 *         2.可以实现打印啥出去，就是啥出去。
 *     打印流的构造器：
 *         public PrintStream(OutputStream os):
 *         public PrintStream(String filepath):
 *
 *     小结：
 *          打印流可以方便，且高效的打印各种数据。
 *          PrintStream不光可以打印数据，还可以写"字节数据"出去。
 *          PrintWriter不光可以打印数据，还可以写"字符数据"出去。
 *
 *
 * ---------------------------------------------------------------
 * 目标：打印流改变输出的流向。重定向。
 *
 *     System:
 *         public static void setOut(PrintStream out) :让系统的输出流向打印流。
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 1.打印流PrintStream
        //OutputStream os = new FileOutputStream("Day10Demo/src/dlei08.txt");
        //PrintStream ps = new PrintStream(os);
        PrintStream ps = new PrintStream("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\text01.txt");
        //PrintWriter pw = new  PrintWriter("Day10Demo/src/dlei08.txt");

        ps.println(97); // 写97
        ps.println(110); // 写110
        ps.println("我在黑马快乐的调皮~~");
        ps.println(99.8);
        ps.println(false);
        ps.println('徐');

        // 写字节数据出去
        // ps.write("我爱你".getBytes());

        ps.close();

        printStreamTest();

    }

    private static void printStreamTest() throws FileNotFoundException {
        PrintStream ps = new PrintStream("src\\main\\java\\com\\javabasic\\_day10_字符流缓冲流转换流序列化流打印流属性集\\text01.txt");
        System.setOut(ps);
        System.out.println("__________________ ");
        System.out.println("系统打印重定向");
        System.out.println("test");
        System.out.println("test");
        System.out.println("系统打印重定向");
        System.out.println("__________________ ");
        ps.close();


    }
}
