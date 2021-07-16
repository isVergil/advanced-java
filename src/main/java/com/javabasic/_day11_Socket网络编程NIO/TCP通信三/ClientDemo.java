package com.javabasic._day11_Socket网络编程NIO.TCP通信三;

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
 目标：实现一个服务端可以同时接收多个客户端的消息。

 总结：
 需要在服务端引入多线程。
 每接收一个客户端的Socket通道，就为它分配一个独立的线程来处理它的消息。
 如此便可实现：一个服务端可以同时接收多个客户端的消息。
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        // 1.客户端要请求于服务端的socket管道连接。
        // Socket(String host, int port)
        Socket socket = new Socket("127.0.0.1" , 9999);
        // 2.从socket通信管道中得到一个字节输出流
        OutputStream os = socket.getOutputStream();
        // 3.把低级的字节输出流包装成高级的打印流。
        PrintStream ps = new PrintStream(os);
        // 4.开始发消息出去
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("请说：");
            ps.println(sc.nextLine());
            ps.flush();
        }
    }
}
