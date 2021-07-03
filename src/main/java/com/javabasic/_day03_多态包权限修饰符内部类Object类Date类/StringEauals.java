package com.javabasic._day03_多态包权限修饰符内部类Object类Date类;

/**
 * @ClassName StringEauals
 * @Description TODO
 * @Author bill
 * @Date 2021/7/1 22:13
 * @Version 1.0
 * ---toString-----返回当前对象在堆内存中的地址信息；类的全限名@内存地址
 * ----------------直接输出，默认会调用toString()方法
 * ----------------toString存在的意义是为了被子类重写
 * ---
 * ---
 * ---equals()-----默认是比较两个对象的地址是否相同，相同返回true，反之
 * ----------------直接比较两个对象的地址是否相同可以用 "==" 代替
 * ----------------equals存在的意义是为了被子类重写，以便程序员可以自己来定制比较规则
 * ----------------只要两个对象的内容一样，我们就认为他们是相同的
 **/
public class StringEauals {
    public static void main(String[] args) {
        //toString
        Animal anima = new Animal("test") {
            @Override
            public String toString() {
                return this.name;
            }
        };
        System.out.println(anima);
        System.out.println(anima.toString());

        //equals
        Animal anima1 = new Animal("test1");
        System.out.println(anima1.equals(anima));

        //Objects.equals();
        //比较两个对象 更安全
        //public static boolean equals(Object a, Object b) {
        //    return (a == b) || (a != null && a.equals(b));
        //}
    }
}
