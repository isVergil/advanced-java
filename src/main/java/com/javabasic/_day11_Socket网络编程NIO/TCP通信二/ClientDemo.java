package com.javabasic._day11_Socket网络编程NIO.TCP通信二;

/**
 * @ClassName ClientDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 15:13
 * @Version 1.0
 **/

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/***
 *  目标：客户端可以反复发送数据，服务端可以反复数据！！
 *
 *      分析：
 *         只需要让客户端通过循环进行数据的发送。
 *
 *      产生的问题：
 *         目前服务端只能接收一个客户端请求。
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        // 1.客户端要请求于服务端的socket管道连接。
        // Socket(String host, int port)
        Socket socket = new Socket("127.0.0.1", 9999);
        // 2.从socket通信管道中得到一个字节输出流
        OutputStream os = socket.getOutputStream();
        // 3.把低级的字节输出流包装成高级的打印流。
        PrintStream ps = new PrintStream(os);
        // 4.开始发消息出去
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("请说：");
            ps.println(sc.nextLine());
            ps.flush();
        }
    }
}
