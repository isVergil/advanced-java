package com.internship.bytedance;

/**
 * @ClassName IPV4toINT
 * @Description TODO
 * @Author bill
 * @Date 2021/12/9 14:32
 * @Version 1.0
 **/
/*
 涉及位运算
 */
public class IPV4toINT {

    //大端字节序（big-endian）：按照内存的增长方向，低位数据存储于低位内存(起始地址)中
    //小端字节序（little-endian）：按照内存的增长方向，高位数据存储于低位内存(起始地址)中
    public static void main(String[] args) {
        System.out.println(ipv4ToInt("1.1.1.1"));
        System.out.println(ipv4ToInt("127.0.0.1"));
        System.out.println(ipv4ToInt("255.255.255.255"));

        System.out.println(intToIpv4(-1));
        System.out.println(intToIpv4(16777343));
    }

    //1、在正则中.$|()[{^?*+\\ 是特殊字符，同样的\也是转义符号
    //2、String.contains()方法不需要转义
    //注意原码11111111 11111111 11111111 11111111是个负数 即 -1
    //主机字节序 127.0.0.1  （小端）
    //存储的是网络字节序 即 1.0.0.127 （大端）
    public static int ipv4ToInt(String ipv4_str) {
        String[] ip = ipv4_str.split("\\.");
        if (ip.length != 4) {
            return -2;
        }
        int result = 0;
        for (int i = 0; i < ip.length; i++) {
            int intSlice = Integer.parseInt(ip[i]) << 8 * i;
            result |= intSlice;
        }
        return result;
    }

    //>>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
    //4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
    //>>>：无符号右移。无论是正数还是负数，高位通通补0。
    public static String intToIpv4(int ipv4_int) {
        String[] ipStr = new String[4];
        for (int i = 0; i < 4; i++) {
            int pos = 8 * i;
            //每次取 8 位二进制
            int and = ipv4_int & (255 << pos);
            // 将当前 ip 段转换为 0 ~ 255 的数字，注意这里必须使用无符号右移
            ipStr[i] = String.valueOf(and >>> pos);
        }
        return String.join(".", ipStr);
    }
}
