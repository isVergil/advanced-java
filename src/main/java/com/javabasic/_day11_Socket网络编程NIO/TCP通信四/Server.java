package com.javabasic._day11_Socket网络编程NIO.TCP通信四;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Server
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 15:32
 * @Version 1.0
 **/

// 放弃了1 客户端 一个线程的模型了
// 提供了线程池：
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("----------服务端启动成功------------");
            ServerSocket ss = new ServerSocket(9999);

            // 一个服务端只需要对应一个线程池
            HandlerSocketThreadPool handlerSocketThreadPool =
                    new HandlerSocketThreadPool(3, 100);

            // 客户端可能有很多个
            while (true) {
                Socket socket = ss.accept();
                System.out.println("有人上线了！！");
                // 每次收到一个客户端的socket请求，都需要为这个客户端分配一个
                // 独立的线程 专门负责对这个客户端的通信！！
                handlerSocketThreadPool.execute(new ReaderClientRunnable(socket));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
