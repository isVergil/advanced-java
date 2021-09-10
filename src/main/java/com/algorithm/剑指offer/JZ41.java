package com.algorithm.剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName JZ41   数据流中的中位数
 * @Description TODO
 * @Author bill
 * @Date 2021/9/3 9:46
 * @Version 1.0
 **/
/*
数据流中的中位数
 */
public class JZ41 {
    public static void main(String[] args) {

    }

    class MedianFinder {
        //优先 队列
        Queue<Integer> A, B;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //默认小顶堆
            A = new PriorityQueue<>();
            //设置为大顶堆
            B = new PriorityQueue<>((x, y) -> (y - x));
        }

        public void addNum(int num) {
            //当两堆的数据个数不相等的时候。
            //先将数据先插入 A 小顶堆，再将堆顶元素插入到 B 大顶堆，保证 插入到 B 中的是小的值
            //当两堆的数据个数相等的时候。
            //先将数据先插入 B 大顶堆，再将堆顶元素插入到 A 小顶堆，保证 插入到 A 中的是大的值
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }

}
