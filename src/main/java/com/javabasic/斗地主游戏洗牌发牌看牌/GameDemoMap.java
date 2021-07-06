package com.javabasic.斗地主游戏洗牌发牌看牌;

import java.util.*;

/**
 * @ClassName GameDemoMap
 * @Description TODO
 * @Author bill
 * @Date 2021/7/6 21:43
 * @Version 1.0
 **/
public class GameDemoMap {
    public static final Map<CardNew, Integer> ALL_CARDS_SIZE = new HashMap<>();
    public static final List<CardNew> ALL_CARDS = new ArrayList<>();

    static {
        /** b.做牌 */
        // 1.定义一个数组存储牌的点数，类型确定，个数确定请用数组存储！
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // 2.定义一个数组存储牌的花色，类型确定，个数确定请用数组存储！
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 3.先遍历点数与四种花色组装成牌对象存入到集合中去
        int index = 0;
        for (String number : numbers) {
            // 遍历花色
            for (String color : colors) {
                // 创建一张牌对象封装点数和花色
                CardNew card = new CardNew(number, color);
                ALL_CARDS.add(card);
                ALL_CARDS_SIZE.put(card, index++);
            }
        }
        // 4.单独加入大小王
        ALL_CARDS_SIZE.put(new CardNew("", "🃏"), 52);
        ALL_CARDS_SIZE.put(new CardNew("", "👲"), 53);
        ALL_CARDS.add(new CardNew("", "🃏"));
        ALL_CARDS.add(new CardNew("", "👲"));
        System.out.println("输出新牌：" + ALL_CARDS_SIZE);
        System.out.println("输出新牌：" + ALL_CARDS);
    }

    public static void main(String[] args) {
        //洗牌
        //洗牌
        Collections.shuffle(ALL_CARDS);
        System.out.println("输出新牌：" + ALL_CARDS);

        //定义三个玩家
        List<CardNew> A1 = new ArrayList<>();
        List<CardNew> A2 = new ArrayList<>();
        List<CardNew> A3 = new ArrayList<>();

        //发牌
        //轮询 取模 %3（轮询的长度）
        for (int i = 0; i < ALL_CARDS.size() - 3; i++) {
            //得到当前这张牌对象
            CardNew card = ALL_CARDS.get(i);
            if (i % 3 == 0) {
                A1.add(card);
            } else if (i % 3 == 1) {
                A2.add(card);
            } else if (i % 3 == 2) {
                A3.add(card);
            }
        }

        //看牌
//        System.out.println("A1 ：\t" + A1);
//        System.out.println("A2 ：\t" + A2);
//        System.out.println("A3 ：\t" + A3);

        //底牌 截取集合的最后三张牌
        List<CardNew> lastThreeCard = ALL_CARDS.subList(ALL_CARDS.size() - 3, ALL_CARDS.size());
        System.out.println("底牌：\t" + lastThreeCard);

        //排序牌
        sortCards(A1);
        sortCards(A2);
        sortCards(A3);

        //拿牌
        System.out.println("A1 ：\t" + A1);
        System.out.println("A2 ：\t" + A2);
        System.out.println("A3 ：\t" + A3);
    }

    //牌排序
    private static void sortCards(List<CardNew> cards) {
//        Collections.sort(cards, new Comparator<Card>() {
//            @Override
//            public int compare(Card o1, Card o2) {
//                return o2.getIndex() - o1.getIndex();
//            }
//        });
        Collections.sort(cards, (o1, o2) -> (ALL_CARDS_SIZE.get(o1) - ALL_CARDS_SIZE.get(o2)));
    }
}

class CardNew {
    private String number;
    private String color;
    //存储牌的索引
    private int index;

    public CardNew() {
    }

    public CardNew(String number, String color) {
        this.number = number;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return number + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardNew cardNew = (CardNew) o;
        return index == cardNew.index &&
                Objects.equals(number, cardNew.number) &&
                Objects.equals(color, cardNew.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, index);
    }
}
