package com.javabasic._day09_方法引用Stream流File类递归字节流;

/**
 * @ClassName MethodDemo
 * @Description TODO
 * @Author bill
 * @Date 2021/7/11 20:05
 * @Version 1.0
 **/

import java.util.*;
import java.util.function.IntFunction;

/***
 * 目标：方法引用的概述。(了解)
 *
 *      方法引用：
 *              方法引用是为了进一步简化Lambda表达式的写法。
 *              方法引用的格式：类型或者对象::引用的方法。
 *      关键语法是：“::”
 *
 *      小结：
 *         方法引用可以进一步简化Lambda表达式的写法。
 *         关键语法是：“::”
 *  方法引用有四种形式：
 *         1.静态方法的引用。
 *         2.实例方法的引用。
 *         3.特定类型方法的引用。
 *         4.构造器引用。
 *
 *    1.静态方法的引用。
 *          引用格式：
 *             类名::静态方法。
 *          简化步骤：
 *              a.定义一个静态方法，把需要简化的代码放到一个静态方法中去。
 *            静态方法引用的注意事项
 *               ” 重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。“
 *               小结：
 *                   静态方法引用的格式： 类名::静态方法。
 *                   重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致,才可以引用简化！
 *          如果前后参数是一样的，而且方法是静态方法，既可以使用静态方法引用
 *
 *   2.实例方法的引用
 *           格式： 对象::实例方法。
 *           简化步骤：
 *               a.定义一个实例方法，把需要的代码放到实例方法中去。
 *           实例方法引用的注意事项
 *              ” 重要：被引用的方法的参数列表要和函数式接口中的抽象方法的参数列表一致。“
 *                  // 对象是 System.out = new PrintStream();
 *                  // 实例方法：println()
 *                  // 前后参数正好都是一个
 *                    lists.forEach(s -> System.out.println(s));
 *                    lists.forEach(System.out::println);
 *
 *   3.特定类型方法的引用。
 *            特定类型：String ,任何类型。
 *            格式：特定类型::方法。
 *            注意：
 *               如果第一个参数列表中的形参中的第一个参数作为了后面的方法的调用者，
 *               并且其余参数作为后面方法的形参，那么就可以用特定类型方法引用了。
 *
 *   4.构造器引用。
 *       格式是：类名::new。
 *       注意点：前后参数一致的情况下，又在创建对象就可以使用构造器引用
 *       s -> new Student(s) => Student::new
 *
 *
 */
public class MethodDemo {
    public static void main(String[] args) {
//        List<String> lists = new ArrayList<>();
//        lists.add("java1");
//        lists.add("java2");
//        lists.add("java3");
//
//        lists.forEach(s -> System.out.println(s));
//        // 方法引用！ 前后参数一致
//        lists.forEach(System.out::println);

        List<Student2> lists = new ArrayList<>();
        lists.add(new Student2("1", 1, '1'));
        lists.add(new Student2("2", 2, '2'));
        lists.add(new Student2("3", 3, '3'));

        Collections.sort(lists, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        // Lambda表达式简化参数二：匿名内部类的Comparator写法!
        Collections.sort(lists, (Student2 o1, Student2 o2) -> {
            return o1.getAge() - o2.getAge();
        });

        Collections.sort(lists, (Student2 o1, Student2 o2) -> o1.getAge() - o2.getAge());

        Collections.sort(lists, (o1, o2) -> o1.getAge() - o2.getAge());

        // 使用静态方法进行简化！
        Collections.sort(lists, (o1, o2) -> Student2.compareByAge(o1, o2));
        // 如果前后参数是一样的，而且方法是静态方法，既可以使用静态方法引用
        Collections.sort(lists, Student2::compareByAge);
        System.out.println(lists);


        //---------------------特定类型方法的引用---------------------------------
        String[] strs = new String[]{"James", "AA", "John",
                "Patricia","Dlei" , "Robert","Boom", "Cao" ,"black" ,
                "Michael", "Linda","cao","after","sBBB"};

        // public static <T> void sort(T[] a, Comparator<? super T> c)
        // 需求：按照元素的首字符(忽略大小写)升序排序！！！
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);// 按照元素的首字符(忽略大小写)比较。
            }
        });
        Arrays.sort(strs, (String s1, String s2) -> {
            return s1.compareToIgnoreCase(s2);// 按照元素的首字符(忽略大小写)比较。
        });

        Arrays.sort(strs, ( s1,  s2 ) ->  s1.compareToIgnoreCase(s2));

        // 特定类型的方法引用：
        Arrays.sort(strs,  String::compareToIgnoreCase);

        System.out.println(Arrays.toString(strs));


        //---------------------构造器引用---------------------------------
        List<String> listString = new ArrayList<>();
        listString.add("java1");
        listString.add("java2");
        listString.add("java3");

        // 集合默认只能转成Object类型的数组。
        Object[] objs = listString.toArray();
        System.out.println("Object类型的数组："+ Arrays.toString(objs));

        // 我们想指定转换成字符串类型的数组！！
        // 最新的写法可以结合构造器引用实现 。
        // default <T> T[] toArray(IntFunction<T[]> generator)
//        String[] strs3 = listString.toArray(new IntFunction<String[]>(){
//            @Override
//            public String[] apply(int value) {
//                return new String[value];
//            }
//        });
//
//        String[] strs1 = listString.toArray(s -> new String[s] );
//
//        String[] strs2 = listString.toArray(String[]::new);
//
//        System.out.println("String类型的数组："+ Arrays.toString(strs2));

    }
}

class Student2 {
    private String name;
    private int age;
    private char sex;

    public static int compareByAge(Student2 o1, Student2 o2) {
        return o1.getAge() - o2.getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student = (Student2) o;
        return age == student.age &&
                sex == student.sex &&
                Objects.equals(name, student.name);
    }


    @Override
    public int hashCode() {
        // 只要内容一样，结果地址也一定是一样的！
        return Objects.hash(name, age, sex);
    }

    public Student2() {
    }

    public Student2(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
