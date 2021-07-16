package com.javabasic._day11_Socket网络编程NIO;

/**
 * @ClassName InetAddressDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 14:20
 * @Version 1.0
 **/

import java.net.InetAddress;

/***
 * 目标：InetAddress类概述
 *          一个该类的对象就代表一个IP地址对象。
 *     InetAddress类成员方法：
 *          static InetAddress getLocalHost()
 *             * 获得本地主机IP地址对象。
 *          static InetAddress getByName(String host)
 *             * 根据IP地址字符串或主机名获得对应的IP地址对象。
 *          String getHostName()
 *             * 获得主机名。
 *          String getHostAddress()
 *             * 获得IP地址字符串。
 */
public class InetAddressDemo {
    public static void main(String[] args) throws Exception {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());  //默认公网ip

        //获取局域网 ip
        InetAddress baidu = InetAddress.getByName("www.baidu.com");  //DNS 获取 ip  110.242.68.3
        System.out.println(baidu.getHostName());
        System.out.println(baidu.getHostAddress());  //默认公网ip

        //获取公网 ip 对象
        InetAddress baidu1 = InetAddress.getByName("110.242.68.3");
        System.out.println(baidu1.getHostName());
        System.out.println(baidu1.getHostAddress());  //默认公网ip

        //判断是否 ping 通
        System.out.println(baidu.isReachable(5000));

    }
}
