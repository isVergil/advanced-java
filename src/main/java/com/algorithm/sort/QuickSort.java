package com.algorithm.sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 10:41
 * @Version 1.0
 * 快速排序为什么要从右边开始
 * https://blog.csdn.net/luzhensmart/article/details/112505063?utm_term=%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E4%B8%BA%E4%BB%80%E4%B9%88%E8%A6%81%E4%BB%8E%E5%8F%B3%E8%BE%B9%E5%BC%80%E5%A7%8B&utm_medium=distribute.pc_aggpage_search_result.none-task-blog-2~all~sobaiduweb~default-2-112505063&spm=3001.4430
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] test = new int[]{123, 435, 678, 2343, 6547, 65, 65, 867, 7, 3, 3, 525, 6532, 8, 585, 67};
        //quickSort(test, 0, test.length - 1);

        //quickSort2(test, 0, test.length - 1);
        //quickSort3(test, 0, test.length - 1);

        quickSort4(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));

        Node head = new Node(1);
        Node node1 = new Node(123);
        Node node2 = new Node(54);
        Node node3 = new Node(8);
        Node node4 = new Node(56);
        Node node5 = new Node(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(head);
        quickSort4(head);
        System.out.println(head);
    }

    //先取 中间数 作为游标 left 和 right 作为其实和终点 开始遍历
    public static void quickSort(int[] arr, int left, int right) {
        int l = left, r = right;
        int pivot = arr[(right + left) / 2];
        while (r > l) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r)
            quickSort(arr, left, r);
        if (l < right)
            quickSort(arr, l, right);
    }

    public static void quickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quickSort2(arr, low, part - 1);
            quickSort2(arr, part + 1, high);
        }
    }

    //取第一个数作为 pivot
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            //1、从后往前 找到小于 pivot 的第一个数
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            //2、把这个数放到low位置 high位置空出
            arr[low] = arr[high];
            //3、从前往后 找到大于 pivot 的第一个数
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            //4、把这个数放到high位置 low位置空出
            arr[high] = arr[low];
            //循环直到 low 和 high 相遇
        }
        arr[low] = pivot;
        return low;
    }


    private static void quickSort3(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作（以 arr[l] 作为基准数）
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        // 递归左（右）子数组执行哨兵划分
        quickSort3(arr, l, i - 1);
        quickSort3(arr, i + 1, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //一种更加普遍适用的算法 适合数组和链表
    //pivot 取数组第一个，i,j为第二个元素下标
    //1、若 nums[pivot] <= nums[j]  则 j++
    //2、若 nums[pivot] > nums[j]  则交换 i，j，然后 i++,j++
    //最后交换 nums[pivot] 和 nums[i-1]
    //循环直到 j 到达尽头
    private static void quickSort4(int[] nums, int left, int right) {
        if (right < left) {
            return;
        }
        int pivot = left;
        int i = left + 1;
        int j = left + 1;
        while (j <= right) {
            if (nums[pivot] > nums[j]) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, pivot, i - 1);
        quickSort4(nums, left, i - 2);
        quickSort4(nums, i, right);
    }

    //快排链表 方法同上
    private static void quickSort4(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        subSort(head, tail);
    }

    private static void subSort(Node low, Node high) {
        if (low == null || low.next == null || low == high) {
            return;
        }
        int privot = low.val;
        Node i = low.next;
        Node i_pre = low;
        Node j = low.next;
        while (j != high.next) {
            if (j.val < privot) {
                swapNode(i, j);
                i_pre = i;
                i = i.next;
            }
            j = j.next;
        }
        swapNode(low, i_pre);
        subSort(low, i_pre);
        subSort(i, high);

    }

    public static void swapNode(Node i, Node j) {
        int temp = i.val;
        i.val = j.val;
        j.val = temp;
    }

}

class Node {
    int val;
    Node next = null;

    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        Node cur = this;
        String out = "";
        while (cur != null) {
            out += ("=>" + cur.val);
            cur = cur.next;
        }
        return out;
    }
}
