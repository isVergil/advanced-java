package com.juc.生产者消费者;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @ClassName ProducerConsumer_WaitNotify
 * @Description TODO
 * @Author bill
 * @Date 2022/4/10 20:08
 * @Version 1.0
 **/
@Slf4j(topic = "c.ProducerConsumer_WaitNotify")
public class ProducerConsumer_WaitNotify {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(2);
        //生产者线程
        for (int i = 1; i < 4; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, '值' + id));
            }, "生产者-" + i).start();
        }

        //消费者线程
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    messageQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "消费者").start();
    }
}

@Slf4j(topic = "c.MessageQueue")
class MessageQueue {

    public MessageQueue(int capcity) {
        this.capcity = capcity;
    }

    //消息队列集合
    private LinkedList<Message> list = new LinkedList<>();

    //容量
    private int capcity;

    //获取消息  消费者
    public Message take() {
        synchronized (list) {
            //队列为空就不能取
            while (list.isEmpty()) {
                try {
                    log.debug("队列为空，消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            log.debug("已消费：{}", message);
            list.notifyAll();
            return message;
        }
    }

    //存入消息  生产者
    public void put(Message message) {
        synchronized (list) {
            //队列满就不能存
            while (list.size() == capcity) {
                try {
                    log.debug("队列满了，生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            log.debug("已生产：{}", message);
            list.notifyAll();
        }
    }
}

//只能构造的时候赋值，后面就不能修改了
@Slf4j(topic = "c.Message")
class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }
}