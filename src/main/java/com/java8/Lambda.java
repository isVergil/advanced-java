package com.java8;

import java.util.Comparator;
import java.util.function.*;

/**
 * @ClassName Lambda
 * @Description TODO
 * @Author bill
 * @Date 2022/9/21 4:00
 * @Version 1.0
 **/
public class Lambda {

    public static void main(String[] args) {

        //@FunctionalInterface 函数式接口 省略
        new Thread(() -> System.out.println("run")).start();


        System.out.println(cal((l, r) -> l + r));
        System.out.println(cal(Integer::sum));


        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value == 7;
            }
        });
        printNum(value -> value % 2 == 0);


        //方法泛型
        Integer res = typeCover(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });
        Integer res1 = typeCover((String s) -> {
            return Integer.valueOf(s);
        });
        String res2 = typeCover(s -> s + "abc");
        System.out.println(res2);
        Integer res3 = typeCover(Integer::valueOf);
        System.out.println(res1);


        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        //简化
        foreachArr(System.out::println);
        foreachArr(a -> {
            if (a % 2 == 0) {
                System.out.println(a);
            }
        });


    }

    //只关注参数列表 和 具体的操作  不关注过程
    static void printNum(IntPredicate predicate) {
        int[] nums = {1, 2, 3, 45, 6, 6, 7, 11};
        for (int num : nums) {
            if (predicate.test(num)) {
                System.out.println(num);
            }
        }
    }

    static int cal(IntBinaryOperator operator) {
        int a = 10;
        int b = 20;
        return operator.applyAsInt(a, b);
    }

    //Function 方法泛型 <参数类型，返回值类型>
    static <R> R typeCover(Function<String, R> function) {
        String cur = "12323";
        R res = function.apply(cur);
        return res;
    }

    //生产型、函数型、断言型、消费型
    static void foreachArr(IntConsumer intConsumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 999, 0};
        for (int i : arr) {
            intConsumer.accept(i);
        }
    }


}
