package com.javabasic._day06_Map集合HashMapTreeMap斗地主图书管理系统排序算法;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName MapPraticsDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/6 21:00
 * @Version 1.0
 * 目标：输出一个字符串中每个字符出现的次数。（经典面试题）
 * ---
 * 分析：
 * （1）键盘录入一个字符串。aabbccddaa123。
 * （2）定义一个Map集合，键是每个字符，值是其出现的次数。 {a=4 , b=2 ,...}
 * （3）遍历字符串中的每一个字符。
 * （4）拿着这个字符去Map集合中看是否有这个字符键，有说明之前统计过，其值+1
 * 没有这个字符键，说明该字符是第一次统计，直接存入“该字符=1”
 **/
public class MapPraticsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String datas = scanner.nextLine();
        Map<Character, Integer> infos = new HashMap<>();
        for (int i = 0; i < datas.length(); i++) {
            char ch = datas.charAt(i);
            if (infos.containsKey(ch)) {
                infos.put(ch, infos.get(ch) + 1);
            } else {
                infos.put(ch, 1);
            }
        }
        System.out.println(infos);

    }
}
