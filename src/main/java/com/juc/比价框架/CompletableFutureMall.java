package com.juc.比价框架;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName CompletableFutureMall
 * @Description 使用 CompletableFuture 的高性能比价框架
 * @Author bill
 * @Date 2022/6/13 0:48
 * @Version 1.0
 **/
public class CompletableFutureMall {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );

    //普通
    public static List<String> getPrice(List<NetMall> list, String productName) {
        return list
                .stream() //----流式计算做了映射（利用map），希望出来的是有格式的字符串（利用String.format）,%是占位符
                .map(netMall ->
                        String.format(productName + " in %s price is %.2f",
                                netMall.getNetMallName(),//第一个%
                                netMall.calcPrice(productName)))
                .collect(Collectors.toList());//第二个%
    }

    //使用CompletableFuture
    //List<CompletableFuture<String>> --->  List<String>
    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        return list
                .stream() //----流式计算做了映射（利用map），希望出来的是有格式的字符串（利用String.format）,%是占位符
                .map(netMall ->
                        CompletableFuture.supplyAsync(() ->
                                String.format(productName + " in %s price is %.2f",
                                        netMall.getNetMallName(),//第一个%
                                        netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(s -> s.join())
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //List<String> list1 = getPrice(list, "mysql");
        List<String> list1 = getPriceByCompletableFuture(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("---当前操作花费时间----costTime:" + (endTime - startTime) + "毫秒");
    }
}

class NetMall {
    @Getter
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);//用这句话来模拟价格
    }
}