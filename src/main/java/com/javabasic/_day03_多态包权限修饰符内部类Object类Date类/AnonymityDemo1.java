package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName AnonymityDemo1
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 21:15
 * @Version 1.0
 **/
public class AnonymityDemo1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("登陆界面");
        //窗口大小
        jFrame.setSize(400, 300);
        //居中
        jFrame.setLocationRelativeTo(null);
        //添加按钮
        JButton btn = new JButton("开始登陆");
        JPanel panel = new JPanel();
        panel.add(btn);
        jFrame.add(panel);
        //按钮绑定事件
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("用户触发了登录");
//            }
//        });
        //简化
        btn.addActionListener(s -> System.out.println("用户触发了登录"));

        //显示窗口
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
