package com.javabasic._day11_Socket网络编程NIO.TCP通信一;

/**
 * @ClassName ClientDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 14:48
 * @Version 1.0
 **/

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/***
 * 目标：TCP可靠传输通信入门案例（非常重要）。
 *      TCP通信四/IP协议 ==> Transfer Control Protocol ==> 传输控制协议
 *      TCP通信四/IP协议的特点
 *      * 面向连接的协议
 *      * 只能由客户端主动发送数据给服务器端，服务器端接收到数据之后，可以给客户端响应数据。
 *      * 通过三次握手建立连接，连接成功形成数据传输通道。
 *      * 通过四次挥手断开连接
 *      * 基于IO流进行数据传输
 *      * 传输数据大小没有限制
 *      * 因为面向连接的协议，速度慢，但是是可靠的协议。
 *
 *      TCP协议的使用场景
 *          * 文件上传和下载
 *          * 邮件发送和接收
 *          * 远程登录
 *
 *      TCP协议相关的类
 *          * Socket
 *              * 一个该类的对象就代表一个客户端程序。
 *          * ServerSocket
 *              * 一个该类的对象就代表一个服务器端程序。
 *
 *      TCP通信也叫Socket网络编程，只要代码基于Socket开发，底层就是基于了可靠传输的TCP通信。
 *
 *      Socket类构造方法
 *          * Socket(String host, int port)
 *          * 根据ip地址字符串和端口号创建客户端Socket对象
 *          * 注意事项：只要执行该方法，就会立即连接指定的服务器程序，如果连接不成功，则会抛出异常。
 *                如果连接成功，则表示三次握手通过。
 *
 *      Socket类常用方法
 *          * OutputStream getOutputStream(); 获得字节输出流对象
 *          * InputStream getInputStream();获得字节输入流对象
 *
 *      客户端的开发流程：
 *          1.客户端要请求于服务端的socket管道连接。
 *          2.从socket通信管道中得到一个字节输出流
 *          3.通过字节输出流给服务端写出数据。
 *      服务端的开发流程：
 *          1.注册端口。
 *          2.接收客户端的Socket管道连接。
 *          3.从socket通信管道中得到一个字节输入流。
 *          4.从字节输入流中读取客户端发来的数据。
 *
 *      需求：客户端发送一行数据，服务端接收一行数据！！
 *      小结：
 *         1.客户端用Socket连接服务端。
 *         2.服务端用ServerSocket注册端口，接收客户端的Socket连接。
 *         3.通信是很严格的，对方怎么发，你就应该怎么收，对方发多少你就只能收多少。
 *         4.实现的面向连接的socket端到端的通信管道，一方如果出现问题，另一方会出现异常！
 */
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        //1.客户端要请求于服务端的socket管道连接。
        Socket socket = new Socket("127.0.0.1", 8888);

        //2.从socket通信管道中得到一个字节输出流
        OutputStream outputStream = socket.getOutputStream();

        //3.把低级的字节输入流包装成高级的打印流
        PrintStream printStream = new PrintStream(outputStream);

        //4.开始发消息
        printStream.println("今晚约吗？");
        printStream.flush();
        System.out.println("客户端发送完毕");
    }
}
