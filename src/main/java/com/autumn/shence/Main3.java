package com.autumn.shence;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author bill
 * @Date 2022/10/13 19:45
 * @Version 1.0
 **/
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //优先队列 求 x = nums[j] - j + nums[i] + i
        PriorityQueue<Integer> deque = new PriorityQueue<>((a, b) -> b - a);
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty()) {
                res = Math.max(res, deque.peek() + nums[i] - i);
            }
            deque.offer(nums[i] + i);
        }
        System.out.println(res);

    }

}
