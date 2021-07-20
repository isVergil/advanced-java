package com.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author bill
 * @Date 2021/6/25 14:10
 * @Version 1.0
 * 线程的两种创建方法
 **/
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
//        Thread t = new Thread() {
//            @Override
//            public void run() {
//                log.debug("running");
//            }
//        };
//        t.setName("t1");
//        t.start();
//        log.debug("running");

//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                log.debug("running");
//            }
//        };
//        Thread t = new Thread(run);
//        t.start();

        HashMap<String, String> maps = new HashMap<>();
        maps.put("1", "1");
        maps.put("2", "1");
        maps.put("3", "1");
        //Object dad = maps.get("1");
        String dad1 = maps.get("1");
        //System.out.println(dad.hashCode());
        System.out.println(dad1.hashCode());
        dad1 = "fsfgsg";
        System.out.println(maps);

        String test1 = new String("aaa");
        String test2 = "aaa";
        System.out.println(test1 == test2);
        test1 = test1.intern();
        System.out.println(test2 == test1);

        float fff = 1.1f;

        Cup aCup = new Cup();
        BrokenCup aBrokenCup = new BrokenCup();

        String s = "Ea";

        String d = "FB";

        System.out.println(s.hashCode());

        System.out.println(d.hashCode());


    }
}

class Cup {
    public void addWater(int w) {
        this.water = this.water + w;
    }

    public void drinkWater(int w) {
        this.water = this.water - w;
    }

    private int water = 0;
}

class BrokenCup extends Cup {
    public void addWater(int w) {
        System.out.println("shit, broken cup");
    }

    public void drinkWater(int w) {
        System.out.println("om...num..., no water inside");
    }
}
