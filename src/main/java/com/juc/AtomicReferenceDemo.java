package com.juc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/8/26 15:41
 * @Version 1.0
 **/

public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User user1 = new User("chen", 18);
        User user2 = new User("yi", 17);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);
        System.out.println(atomicReference.compareAndSet(user1, user2) + "\t" + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(user2, user1) + "\t" + atomicReference.get());

    }
}

@Getter
@ToString
@AllArgsConstructor
class User {
    String username;
    int age;
}
