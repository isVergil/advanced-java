package com.javabasic.斗地主游戏洗牌发牌看牌;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * @ClassName GameDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 22:58
 * @Version 1.0
 **/
public class GameDemo {
    /**
     * a.定义一个静态集合，存储54张牌对象，集合只需要一个
     */
    public static final List<Card> ALL_CARDS = new ArrayList<>();

    /** b.做牌 */
    static {
        // 1.定义一个数组存储牌的点数，类型确定，个数确定请用数组存储！
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 2.定义一个数组存储牌的花色，类型确定，个数确定请用数组存储！
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 3.先遍历点数与四种花色组装成牌对象存入到集合中去
        for (String number : numbers) {
            // 遍历花色
            for (String color : colors) {
                // 创建一张牌对象封装点数和花色
                Card card = new Card(number, color);
                ALL_CARDS.add(card);
            }
        }
        // 4.单独加入大小王
        Collections.addAll(ALL_CARDS, new Card("", "🃏"), new Card("", "👲"));
        System.out.println("输出新牌：" + ALL_CARDS);
    }

    public static void main(String[] args) {
        //洗牌
        Collections.shuffle(ALL_CARDS);
        System.out.println("输出新牌：" + ALL_CARDS);

        //定义三个玩家
        List<Card> A1 = new ArrayList<>();
        List<Card> A2 = new ArrayList<>();
        List<Card> A3 = new ArrayList<>();

        //发牌
        //轮询 取模 %3（轮询的长度）
        for (int i = 0; i < ALL_CARDS.size() - 3; i++) {
            //得到当前这张牌对象
            Card card = ALL_CARDS.get(i);
            if (i % 3 == 0) {
                A1.add(card);
            } else if (i % 3 == 1) {
                A2.add(card);
            } else if (i % 3 == 2) {
                A3.add(card);
            }
        }

        //看牌
        System.out.println("A1 ：\t" + A1);
        System.out.println("A2 ：\t" + A2);
        System.out.println("A3 ：\t" + A3);

        //底牌 截取集合的最后三张牌
        List<Card> lastThreeCard = ALL_CARDS.subList(ALL_CARDS.size() - 3, ALL_CARDS.size());
        System.out.println("底牌：\t" + lastThreeCard);


    }
}
