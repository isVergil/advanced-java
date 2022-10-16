package com.test;

/**
 * @ClassName ReverseList
 * @Description TODO
 * @Author bill
 * @Date 2022/9/15 9:55
 * @Version 1.0
 **/
public class ReverseList {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = null;
        System.out.println(root.toString());
        Node newHead = reverseK(root, 2);
        System.out.println(newHead.toString());
    }

    static Node reverseK(Node root, int k) {
        if (root == null || root.next == null) {
            return root;
        }
        //链表长度
        int len = 0;
        Node cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len <= k) {
            return root;
        }
        Node dummyNode = new Node(-1);
        dummyNode.next = root;
        Node prev = dummyNode;
        cur = prev;
        int i = 0;
        while (i + k <= len) {
            Node prevHead = prev.next;
            //遍历到 k
            for (int j = 0; j < k; j++) {
                if (cur == null) {
                    return dummyNode.next;
                }
                cur = cur.next;
            }
            //保存下个k 的起点
            Node newStart = cur.next;
            cur.next = null;
            prev.next = reverse(prevHead);
            cur = newStart;
            prev = prevHead;
            i += k;
        }
        return dummyNode.next;

    }

    static Node reverse(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        Node prev = null, cur = root;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        Node cur = this;
        StringBuilder sb = new StringBuilder();
        while (cur != null) {
            sb.append(cur.val + "  ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
