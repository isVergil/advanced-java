package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

/**
 * @ClassName AnonymityDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 21:09
 * @Version 1.0
 * 需求：很多角色要一起参加游泳比赛（老师，学生，运动员）
 **/
public class AnonymityDemo {
    public static void main(String[] args) {
        Swim bill = new Swim() {
            @Override
            public void swimming() {
                System.out.println("游泳");
            }
        };
        go(bill);

        go(new Swim() {
            @Override
            public void swimming() {
                System.out.println("匿名调用");
            }
        });
    }

    public static void go(Swim swim) {
        System.out.println("开始");
        swim.swimming();
        System.out.println("结束");
    }
}

interface Swim {
    void swimming();
}
