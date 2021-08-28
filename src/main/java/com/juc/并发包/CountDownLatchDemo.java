package com.juc.并发包;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/27 15:41
 * @Version 1.0
 **/
/*
 倒计时结束完成操作
让一些线程阻塞直到另一些线程完成一系列操作才被唤醒
CountDownLatch 主要有两个方法，当一个或多个线程调用await 方法时，调用线程就会被阻塞。
其它线程调用CountDown 方法会将计数器减1（调用CountDown方法的线程不会被阻塞），
当计数器的值变成零时，因调用await 方法被阻塞的线程会被唤醒，继续执行

//等待以上6个线程完成
//主线程 +  gc 线程
//while (Thread.activeCount() > 2) {
//     //让出线程
//     Thread.yield();
//}
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t do sth");
                countDownLatch.countDown();
            }, CountryEnum.foreach_CountryEnum(i).getRetMsg()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦统一六国");

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t do sth");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t finished");
    }
}

@AllArgsConstructor
@Getter
enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
    private Integer retCode;
    private String retMsg;

    public static CountryEnum foreach_CountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (index == countryEnum.retCode) {
                return countryEnum;
            }
        }
        return null;
    }
}
