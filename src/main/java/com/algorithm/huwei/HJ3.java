package com.algorithm.huwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName HJ3
 * @Description HJ3 明明的随机数
 * @Author bill
 * @Date 2022/6/18 23:28
 * @Version 1.0
 **/
public class HJ3 {
    /*
    明明生成了N个1到500之间的随机整数。
    请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        while (N-- > 0) {
            set.add(Integer.parseInt(br.readLine()));
        }
        Object[] res = set.toArray();
        Arrays.sort(res);
        for (Object i : res) {
            System.out.println(i);
        }

    }
}
