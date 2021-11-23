package com.algorithm.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName JZ38
 * @Description TODO
 * @Author bill
 * @Date 2021/9/16 15:09
 * @Version 1.0
 **/
/*
字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class JZ38 {

    //HashSet 去重
    Set<String> res = new HashSet<>();
    boolean[] visited;

    public String[] permutation(String s) {
        char[] sArray = s.toCharArray();
        visited = new boolean[s.length()];
        backtrack(sArray, new StringBuilder());
        return res.toArray(new String[0]);
    }

    // 回溯函数
    public void backtrack(char[] ch, StringBuilder sb) {
        // 终止条件
        if (sb.length() == ch.length) {    //注意 StringBuilder 没有 size() 方法
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            //剪枝
            if (i > 0 && ch[i] == ch[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i] == false) {
                sb.append(ch[i]);
                visited[i] = true;
                backtrack(ch, sb);
                sb.deleteCharAt(sb.length() - 1);   //注意 StringBuilder 的删除最后一个元素 deleteCharAt
                visited[i] = false;
            }
        }
    }


}

