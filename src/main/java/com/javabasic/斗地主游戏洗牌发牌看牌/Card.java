package com.javabasic.斗地主游戏洗牌发牌看牌;

/**
 * @ClassName Poker
 * @Description TODO
 * @Author bill
 * @Date 2021/7/5 22:55
 * @Version 1.0
 **/
public class Card {
    private String number;
    private String color;
    //存储牌的索引
    private int index;

    public Card() {
    }

    public Card(String number, String color, int index) {
        this.number = number;
        this.color = color;
        this.index = index;
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return number + color;
    }
}