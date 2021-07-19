package com.javabasic.Clone实现方式;

import java.io.*;

/**
 * @ClassName CloneDemo2
 * @Description TODO
 * @Author bill
 * @Date 2021/7/19 21:11
 * @Version 1.0
 * 可以通过很简洁的代码即可完美实现深拷贝。不过要注意的是，如果某个属性被transient修饰，那么该属性就无法被拷贝了。
 * https://blog.csdn.net/lylodyf/article/details/52763720
 **/
public class CloneDemo2 {
    public static void main(String[] args) throws Exception {
        //对象序列化
        // 1.创建User用户对象
        DeepCopy2 class1 = new DeepCopy2("bill", 111);
        //通过序列化方法实现深拷贝
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(class1);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        DeepCopy2 class2 = (DeepCopy2) ois.readObject();
        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class1 == class2);
        System.out.println("==============================================");
        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        class1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        class2.setAge(99);
        System.out.println(class1);
        System.out.println(class2);
    }
}

class DeepCopy2 implements Serializable {
    private String name;
    private int age;

    public DeepCopy2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DeepCopy2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + this.hashCode();
    }
}
