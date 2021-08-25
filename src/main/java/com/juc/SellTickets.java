package com.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @ClassName SellTickets
 * @Description TODO
 * @Author bill
 * @Date 2021/7/25 22:47
 * @Version 1.0
 **/
@Slf4j(topic = "c.SellTickets")
public class SellTickets {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow ticketWindow = new TicketWindow(100000);
        //所有线程的集合
        List<Thread> threadList = new ArrayList<>();
        List<Integer> amountList = new Vector<>();
        for (int i = 0; i < 4000; i++) {
            Thread thread = new Thread(() -> {
                //买票
                int amount = ticketWindow.sell(randomAmount());
                amountList.add(amount);
                try {
                    Thread.sleep(randomAmount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threadList.add(thread);
            thread.start();
        }
        //等待所有线程执行结束
        for (Thread thread : threadList) {
            thread.join();
        }
        //统计卖出和剩余票数

        log.debug("余票：{}", ticketWindow.getCount());
        log.debug("卖出的票数：{}", amountList.stream().mapToInt(i -> i).sum());
        log.debug("实际结果：{}", amountList.stream().mapToInt(i -> i).sum() + ticketWindow.getCount());
    }

    static Random random = new Random();

    //随机1-5
    public static int randomAmount() {
        return random.nextInt(5) + 1;
    }

}

//售票窗口
class TicketWindow {
    private int count;

    //余票数
    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    //有余票就卖
    public synchronized int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}
