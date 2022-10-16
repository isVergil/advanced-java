package com.internship.huawei;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName HUAWEI2022042002
 * @Description TODO
 * @Author bill
 * @Date 2022/4/20 20:16
 * @Version 1.0
 **/
public class HUAWEI2022042002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nodes_ = br.readLine();
        String[] children = br.readLine().split("//");
        String nodes__ = br.readLine();
        nodes__ = nodes__.substring(1, nodes__.length() - 1);
        nodes_ = nodes_.substring(1, nodes_.length() - 1);
        String[] nodes = nodes_.split(",");
        int len = nodes.length;
        Node root = new Node(Integer.parseInt(nodes[0]));
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        int i = 1;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            if (i < len && Integer.parseInt(nodes[i]) != 0) {
                cur.left = new Node(Integer.parseInt(nodes[i]));
                deque.offer(cur.left);
                i++;
            }
            if (i < len && Integer.parseInt(nodes[i]) != 0) {
                cur.right = new Node(Integer.parseInt(nodes[i]));
                deque.offer(cur.right);
                i++;
            }
        }
        deque = new LinkedList<>();
        deque.offer(root);
        int child1 = Integer.parseInt(children[0]);
        int child2 = Integer.parseInt(children[1]);
        Node findx;
        boolean left_flag = true;
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            if (cur.left != null) {
                deque.offer(cur.left);
                if (cur.val == child1 || cur.left.val == child2){
                    findx = cur;
                    break;
                }
            }
            if (cur.right != null) {
                deque.offer(cur.right);
                if (cur.val == child1 || cur.right.val == child2){
                    findx = cur;
                    left_flag = false;
                    break;
                }
            }
        }
    }




}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
