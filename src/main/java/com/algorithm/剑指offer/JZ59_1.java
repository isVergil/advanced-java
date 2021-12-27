package com.algorithm.剑指offer;

import java.util.*;

/**
 * @ClassName JZ59_1
 * @Description TODO
 * @Author bill
 * @Date 2021/9/19 18:30
 * @Version 1.0
 **/
public class JZ59_1 {
    //法1  单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        //下面是要注意的点：
        //队列按从大到小放入
        //如果首位值（即最大值）不在窗口区间，删除首位
        //如果新增的值小于队列尾部值，加到队列尾部
        //如果新增值大于队列尾部值，删除队列中比新增值小的值，如果在把新增值加入到队列中
        //如果新增值大于队列中所有值，删除所有，然后把新增值放到队列首位，保证队列一直是从大到小
        if (nums.length == 0) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[nums.length - k + 1];
        int index = 0;  //arr数组的下标
        //未形成窗口区间
        for (int i = 0; i < k; i++) {
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[i]);
        }
        //窗口区间刚形成后，把队列首位值添加到队列中
        //因为窗口形成后，就需要把队列首位添加到数组中，而下面的循环是直接跳过这一步的，所以需要我们直接添加
        arr[index++] = deque.peekFirst();
        //窗口区间形成
        for (int i = k; i < nums.length; i++) {
            //i-k是已经在区间外了，如果首位等于nums[i-k]，那么说明此时首位值已经不再区间内了，需要删除
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            //删除队列中比当前值大的值
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            //把当前值添加到队列中
            deque.addLast(nums[i]);
            //把队列的首位值添加到arr数组中
            arr[index++] = deque.peekFirst();
        }
        return arr;
    }

    //法2  优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        //if (num == null || num.length == 0 || size == 0 || size > num.length) {
        //    return res;
        //}
        //降序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int[] res = new int[nums.length - k + 1];
        //注意边界
        for (int i = 0; i < k - 1; i++) {
            priorityQueue.offer(nums[i]);
        }
        for (int i = 0; i < res.length - k + 1; i++) {
            priorityQueue.offer(nums[i + k - 1]);
            res[i] = priorityQueue.peek();
            //删除窗口外的元素
            priorityQueue.remove(nums[i]);
        }
        return res;
    }

    //单调队列
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList();
        if (size == 0) {
            return res;
        }
        ArrayDeque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < num.length; i++) {
            //deque 不为空 且 deque尾存的下表元素 小于 遍历元素
            //deque 尾出
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && (i - size + 1 > deque.peekFirst())) {
                deque.pollFirst();
            }
            deque.add(i);
            if(i >= size - 1){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
