package com.jvm;

/**
 * @ClassName Error
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 14:25
 * @Version 1.0
 **/
public class ErrorDemo {


    public static void main(String[] args) {
        //StackoverFlowError();
        OutOfMemoryError();
    }

    //StackoverFlowError
    //堆栈溢出，我们有最简单的一个递归调用，就会造成堆栈溢出，也就是深度的方法调用
    public static void StackoverFlowError() {
        StackoverFlowError();
    }

    //OutOfMemoryError
    //java heap space
    //创建了很多对象，导致堆空间不够存储
    public static void OutOfMemoryError() {
        // 堆空间的大小 -Xms10m -Xmx10m
        // 创建一个 80M 的字节数组
        byte[] bytes = new byte[80 * 1024 * 1024];
    }

    //GC overhead limit exceeded
    //GC 回收时间过长时会抛出OutOfMemoryError，过长的定义是，超过了98%的时
    //间用来做GC，并且回收了不到2%的堆内存连续多次GC 都只回收了不到2%的极端情况下，才会抛出。假设不抛出GC
    //overhead limit 错误会造成什么情况呢？
    //那就是GC 清理的这点内存很快会再次被填满，迫使GC 再次执行，这样就形成了恶性循环，CPU 的使用率一直都是100%，而GC 却没有任何成果。
}
