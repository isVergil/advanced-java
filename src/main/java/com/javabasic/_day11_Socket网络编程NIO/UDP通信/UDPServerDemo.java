package com.javabasic._day11_Socket网络编程NIO.UDP通信;

/**
 * @ClassName UDPServerDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 14:31
 * @Version 1.0
 **/

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/***
 * 目标：UDP服务端开发。接收客户端的消息。
 */
public class UDPServerDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("==========启动服务端程序===========");
        //1、创建一个接受客户端的数据包对象
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        //2、创建一个接受客户端的码头
        DatagramSocket socket = new DatagramSocket(6666);

        //3、开始接收
        socket.receive(packet);

        //4、获取本次读取的数据量
        int len = packet.getLength();

        //5、输出数据
        String rs = new String(buffer, 0, len);
        System.out.println(rs);

        // 6.服务端还可以获取发来信息的客户端的IP和端口。
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        System.out.println("对方："+ip+":"+port);

        socket.close();
    }
}
