package com.javabasic.Clone实现方式;

/**
 * @ClassName CloneDemo1
 * @Description TODO
 * @Author bill
 * @Date 2021/7/19 20:48
 * @Version 1.0
 **/
public class CloneDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepCopy1 class1 = new DeepCopy1("1", 1, new ChildOfDeepCopy1("bill"));
        DeepCopy1 class2 = class1.clone();
        System.out.println(class1 == class2);
        System.out.println(class1.getChildOfDeepCopy1() == class2.getChildOfDeepCopy1());
        class1.setAge(13);
        System.out.println("===========================================");
        System.out.println(class1);
        System.out.println(class2);
        System.out.println(class1 == class2);
    }
}

class DeepCopy1 implements Cloneable {
    private String name;
    private int age;
    private ChildOfDeepCopy1 childOfDeepCopy1;

    public DeepCopy1(String name, int age, ChildOfDeepCopy1 childOfDeepCopy1) {
        this.name = name;
        this.age = age;
        this.childOfDeepCopy1 = childOfDeepCopy1;
    }

    public ChildOfDeepCopy1 getChildOfDeepCopy1() {
        return childOfDeepCopy1;
    }

    public void setChildOfDeepCopy1(ChildOfDeepCopy1 childOfDeepCopy1) {
        this.childOfDeepCopy1 = childOfDeepCopy1;
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

    //重写 clone 方法
    @Override
    protected DeepCopy1 clone() throws CloneNotSupportedException {
        // ChildOfDeepCopy1 浅拷贝
        //return (DeepCopy1) super.clone();

        //深拷贝
        DeepCopy1 deepCopy1 = (DeepCopy1) super.clone();
        deepCopy1.childOfDeepCopy1 = deepCopy1.childOfDeepCopy1.clone();
        return deepCopy1;
    }

    @Override
    public String toString() {
        return "DeepCopy1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + this.hashCode();
    }
}

class ChildOfDeepCopy1 implements Cloneable {
    private String childName;

    public ChildOfDeepCopy1(String childName) {
        this.childName = childName;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    @Override
    protected ChildOfDeepCopy1 clone() throws CloneNotSupportedException {
        return (ChildOfDeepCopy1) super.clone();
    }

}
