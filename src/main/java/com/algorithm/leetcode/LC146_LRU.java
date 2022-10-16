package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @ClassName LC146_LRU
 * @Description TODO
 * @Author bill
 * @Date 2021/8/16 13:52
 * @Version 1.0
 **/

// 法一：HashMap + 双向链表 实现
public class LC146_LRU {
    class Node {
        Node next;
        Node pre;
        int key;
        int value;

        Node(int k, int v) {
            next = this;
            pre = this;
            key = k;
            value = v;
        }
    }

    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;

    public LC146_LRU(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            //放到链表头
            refresh(node);
            return node.value;
        }
        return -1;
    }

    //1、put 已存在的 node 就直接放到链表头
    //2、put 不存在的 node 就直接放到链表头
    //--2.1、若 put 之后大于超过容量，要删除最后一个 node
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            //放到链表头
            refresh(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            //放到链表头
            refresh(node);
            if (map.size() > capacity) {
                //删除最近未使用节点 即链表末尾节点
                deleteNode();
            }
        }
    }

    //更新 node 为最近使用的节点。即加head.next
    private void refresh(Node node) {
        //获取节点 node
        //1、断开 node 节点
        node.next.pre = node.pre;
        node.pre.next = node.next;
        //将 node 加到 head.next
        //2、将 node 和 head.next 相连
        node.next = head.next;
        head.next.pre = node;
        //3、将 head 和 node 相连
        head.next = node;
        node.pre = head;
    }

    //删除最近未使用节点 即链表末尾
    private void deleteNode() {
        //获取 head.pre 并删除  同上
        Node node = head.pre;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        map.remove(node.key);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(4, 0.75f, true);
        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 1);
        map.put(4, 1);
        map.put(5, 1);
        System.out.println(map);
    }
}


// 法二：LinkedHashMap 实现
class LRUCache {
    private int cap;
    private LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        //最大容量（最大 2^30 10亿 自动扩容），装填因子（扩容机制），迭代顺序
        //true时，表示按照访问顺序迭代；值为false时，表示按照插入顺序迭代
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.cap = capacity;
    }

    //LinkedHashMap中重写了HashMap的get方法，不止会取出所索要的节点的值，而且会调整LinkedHashMap中内置的链表中该键所对应的节点的位置，将该节点置为链表的尾部。
    public int get(int key) {
        //map.getOrDefault(key, -1);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return -1;
    }

    //尾部插入
    //或者重写 removeEldestEntry 即每次调用put方法时都会调用 removeEldestEntry 来删除最久没访问的元素
    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > cap) {
            //迭代删除最近最少使用的元素
            Iterator it = map.keySet().iterator();
            map.remove(it.next());
        }
    }
}
