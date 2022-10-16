package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC146
 * @Description LRU 缓存
 * @Author bill
 * @Date 2022/3/31 14:15
 * @Version 1.0
 **/
public class LC146 {
    //1、hashmap + 双向链表
    //2、LinkedHashMap 实现
}

//法1 hashmap + 双向链表
//双链表中实现的方法：
//     更新 node 为最近使用的节点 refresh
//     删除最近未使用节点 即链表末尾   deleteNode
//LRU 缓存中的方法
//     put 插入 refresh 节点 若超过长度 deleteNode
//     get

class LRUCache {
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
    HashMap<Integer, Node> map;
    Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            refresh(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            refresh(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            refresh(node);
            if (map.size() > capacity) {
                deleteNode();
            }
        }
    }

    //更新 node 为最近使用的节点
    //即放到 head.next
    private void refresh(Node node) {
        //截取节点 node 即 “删除” node
        //双向链表删除节点标准写法
        //节点只有两个时同样适用
        node.next.pre = node.pre;
        node.pre.next = node.next;
        //将 node 加到 head.next
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    //删除最近未使用节点
    //即链表末尾
    private void deleteNode() {
        //获取 head.pre 并删除  同上
        Node node = head.pre;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        map.remove(node.key);
    }
}

//法2 LinkedHashMap 实现
class LRUCache1 {

    int cap;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache1(int capacity) {
        cap = capacity;
        map = new LinkedHashMap<>(cap, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > cap) {
            Iterator iterator = map.keySet().iterator();
            map.remove(iterator.next());
        }
    }
}
