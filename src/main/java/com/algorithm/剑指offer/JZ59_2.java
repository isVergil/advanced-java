package com.algorithm.剑指offer;

import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName JZ59_2
 * @Description TODO
 * @Author bill
 * @Date 2021/9/19 16:37
 * @Version 1.0
 **/
/*
队列的最大值
 */
public class JZ59_2 {

    class MaxQueue {

        Queue<Integer> queue;

        //双端队列 递减 来维护最大最小值
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        //1、deque 为空   说明没有最大值 返回 -1
        //2、deque 不为空 说明有最大值   返回 双端队列的队头元素值
        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        //入队
        //1、元素直接入队
        //2、如果队尾元素小于入队元素则删除队尾元素 保证 deque 的递减
        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        //出队
        //1、queue 为空 则返回 -1
        //1、queue 不为空
        //---判断 queue队头元素 == deque队头元素
        //---等于则先删除 deque队头元素
        //---最后queue出队
        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.poll();
        }

        // 两个都返回的是Integer，作比较时，不会发生自动拆装箱，
        // 而且如果直接queue.offer(int类型)，自动拆装箱是有缓存机制的，
        // 当直接用==比较时，比较的是对象地址，
        // 如queue.offer(126)，queue.offer(126)此时==返回true，
        // 但queue.offer(900)，queue.offer(900)此时返回false
    }
}
