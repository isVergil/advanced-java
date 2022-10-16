package com.autumn.tencent;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author bill
 * @Date 2022/10/16 20:56
 * @Version 1.0
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(sc.nextInt());
        }
        int idx = 1;
        while (idx <= n) {
            if (idx == n) {
                System.out.print(deque.pollLast() + " ");
                break;
            }
            int first = deque.peekFirst();
            int end = deque.peekLast();
            //奇数 选大的
            if ((idx & 1) == 1) {
                if (first > end) {
                    System.out.print(deque.pollFirst() + " ");
                } else {
                    System.out.print(deque.pollLast() + " ");
                }
            } else {
                if (first < end) {
                    System.out.print(deque.pollFirst() + " ");
                } else {
                    System.out.print(deque.pollLast() + " ");
                }
            }
        }

    }
}
