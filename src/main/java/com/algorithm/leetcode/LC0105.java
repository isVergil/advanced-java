package com.algorithm.leetcode;

/**
 * @ClassName LC0105
 * @Description 面试题 01.05. 一次编辑
 * @Author bill
 * @Date 2022/5/13 10:13
 * @Version 1.0
 **/
public class LC0105 {

    public static void main(String[] args) {
        //"islander"
        //"slander"
        System.out.println(new LC0105().oneEditAway("islander", "slander"));
    }

    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        if (Math.abs(firstLen - secondLen) > 1) {
            return false;
        }
        if (firstLen > secondLen) {
            return oneEditAway(second, first);
        }
        int l1 = 0, l2 = 0, res = 0;
        while (l1 < firstLen && l2 < secondLen && res <= 1) {
            if (first.charAt(l1) == second.charAt(l2)) {
                l1++;
                l2++;
            } else {
                if (firstLen == secondLen) {
                    l1++;
                    l2++;
                } else {
                    l2++;
                }
                res++;
            }
        }
        return res <= 1;
    }
}
