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

    public Card() {
    }

    public Card(String number, String color) {
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
        return number+color;
    }
}