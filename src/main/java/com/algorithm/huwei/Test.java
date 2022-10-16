package com.algorithm.huwei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author bill
 * @Date 2022/7/15 10:39
 * @Version 1.0
 **/
public class Test {

    /**
     * 汽水瓶
     //public static void main(String[] args) throws IOException {
     //    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     //    int cur = 0;
     //    int max = 10;
     //    while (max-- > 0) {
     //        cur = Integer.parseInt(br.readLine());
     //        if (cur == 0) {
     //            break;
     //        }
     //        System.out.println(dfs(cur));
     //    }
     //}
     //
     ////当前 数量的 curBowl 能喝的汽水数量
     //static int dfs(int curBowl) {
     //    //剩1瓶 喝不了了
     //    if (curBowl <= 1) {
     //        return 0;
     //    }
     //    //剩2瓶 找老板借一瓶 换汽水 还一个空瓶 即还能喝一瓶
     //    if (curBowl == 2) {
     //        return 1;
     //    }
     //    return dfs(curBowl % 3 + curBowl / 3) + curBowl / 3;
     //}
     */

    /**
     * 明明的随机数
     * <p>
     * //public static void main(String[] args) {
     * //    Scanner sc = new Scanner(System.in);
     * //    Set<Integer> set = new HashSet();
     * //    int N = sc.nextInt();
     * //    for (int i = 0; i < N; i++) {
     * //        set.add(sc.nextInt());
     * //    }
     * //    int[] nums = new int[set.size()];
     * //    int i = 0;
     * //    for (Integer item : set) {
     * //        nums[i++] = item;
     * //    }
     * //    Arrays.sort(nums);
     * //    for (int num : nums) {
     * //        System.out.println(num);
     * //    }
     * //}
     */

    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('A', 10);
        map.put('a', 10);
        map.put('B', 11);
        map.put('b', 11);
        map.put('C', 12);
        map.put('c', 12);
        map.put('D', 13);
        map.put('d', 13);
        map.put('E', 14);
        map.put('e', 14);
        map.put('F', 15);
        map.put('f', 15);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ox = br.readLine();
        ox = ox.substring(2);
        int res = 0;
        int flag = 1, leap = 16;
        for (int i = ox.length() - 1; i >= 0; i--) {
            res += (map.get(ox.charAt(i)) * flag);
            flag *= leap;
        }
        System.out.println(res);
    }
}
