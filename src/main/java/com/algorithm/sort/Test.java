package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 10:17
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 867, 7, 3, 525, 3, 8, 585, 67};

        //quickSort(test, 0, test.length - 1);
        quickSort2(test, 0, test.length - 1);

        //bubbleSort(test);

        //insertSort(test);

        //selectSort(test);
        System.out.println(Arrays.toString(test));


    }

    //快排
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= nums[left]) {
                r--;
            }
            while (l < r && nums[l] <= nums[left]) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, l, left);
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //冒泡排序
    //相邻两两比较 
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }

    //插入排序
    //每次插入元素到有序的数组
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    //选择排序
    //每次选择最小的元素加入到有序队列的最后
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index_min = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[index_min] > nums[j]) {
                    index_min = j;
                }
            }
            //交换 index_min 和 i
            swap(nums, index_min, i);
        }
    }

    //快排 另外一种思路
    public static void quickSort2(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left + 1, j = i;
        while (j <= right) {
            if (nums[left] > nums[j]) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, left, i - 1);
        quickSort2(nums, left, i - 2);
        quickSort2(nums, i, right);

    }

    //快排单链表
    private static void quickSort2(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        linkedListSort(head, tail);
    }

    private static void linkedListSort(Node low, Node high) {
        if (low == null || low.next == null || low == high) {
            return;
        }
        int privot = low.val;
        Node i = low.next;
        Node i_pre = low;
        Node j = low.next;
        while (j != high.next) {
            if (j.val < privot) {
                QuickSort.swapNode(i, j);
                i_pre = i;
                i = i.next;
            }
            j = j.next;
        }
        QuickSort.swapNode(low, i_pre);
        linkedListSort(low, i_pre);
        linkedListSort(i, high);
    }

    //1、快慢指针拆分链表成两部分
    //2、合并两个有序链表
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针拆分链表
        Node slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node l1 = sortList(head);
        Node l2 = sortList(slow);
        return merge(l1, l2);
    }

    //合并两个有序链表
    public Node merge(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return head.next;

    }

}

