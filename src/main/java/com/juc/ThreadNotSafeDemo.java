package com.juc;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName ThreadNotSafeDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/23 23:19
 * @Version 1.0
 **/
@Slf4j(topic = "c.ThreadNotSafeDemo")
public class ThreadNotSafeDemo {


    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}", room.getCounter());

    }
}

class Room {
    private int counter = 0;

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void setCounter(int counter) {
        this.counter = counter;
    }

    public synchronized void increment() {
        counter++;
    }

    public void decrement() {
        counter--;
    }
}
