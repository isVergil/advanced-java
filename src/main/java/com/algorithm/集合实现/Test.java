package com.algorithm.集合实现;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/8/15 10:02
 * @Version 1.0
 **/
public class Test {

    public static void main(String[] args) {

    }
    
}

//双端队列
class MyCircularDeque {

    private int capacity;
    private int size;
    private int[] elements;
    private int head, tail;


    public MyCircularDeque(int k) {
        this.capacity = k;
        this.size = 0;
        this.elements = new int[capacity];
        this.head = this.tail = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //head 先左移再赋值
        head = (head - 1 + capacity) % capacity;
        elements[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        //tail 先赋值再右移
        elements[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        //head 右移动
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        //tail 左移动
        tail = (tail - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return elements[head];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return elements[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}

