package com.javabasic._day11_Socket网络编程NIO;

/**
 * @ClassName BeerDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/16 13:15
 * @Version 1.0
 **/

/***
 *    目标：非规律化递归问题，编程思维的拓展。
 *
 *     啤酒问题：啤酒2元一瓶，4个盖子可以换一瓶，2个空瓶可以换一瓶。
 */
public class BeerDemo {
    //定义一个静态变量存储可以喝酒的总数
    public static int totalNum;
    //瓶子数
    public static int lastPingZiNum;
    //盖子数量
    public static int lastGaiZiNum;

    public static void main(String[] args) {
        buyBeer(10);
        System.out.println("总数" + totalNum);
        System.out.println("剩余瓶子数" + lastPingZiNum);
        System.out.println("剩余盖子数" + lastGaiZiNum);
    }

    //定义一个方法帮助用户买酒
    public static void buyBeer(int money) {
        //拿钱买酒
        int number = money / 2;
        totalNum += number;

        //算出当前的全部瓶子和盖子，换算成金额继续购买
        int currentPingZinum = lastPingZiNum + number;
        int currentGaiZinum = lastGaiZiNum + number;

        //换算成金额
        int totalMoney = 0;
        totalMoney += (currentPingZinum / 2) * 2;
        lastPingZiNum = currentPingZinum % 2;

        totalMoney += (currentGaiZinum / 4) * 2;
        lastGaiZiNum = currentGaiZinum % 4;

        //继续买酒
        if (totalMoney >= 2) {
            buyBeer(totalMoney);
        }

    }
}
