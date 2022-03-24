package com.algorithm.LeetCode热题HOT100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LC22
 * @Description 括号生成
 * @Author bill
 * @Date 2022/3/20 15:29
 * @Version 1.0
 **/
public class LC22 {

    //1、暴力法
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    //2、回溯法
    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder curStr, int leftSum, int rightSum, int len) {
        if (curStr.length() == len * 2) {
            res.add(curStr.toString());
            return;
        }
        if (leftSum < len) {
            curStr.append('(');
            backtrack(res, curStr, leftSum + 1, rightSum, len);
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if (leftSum > rightSum) {
            curStr.append(')');
            backtrack(res, curStr, leftSum, rightSum + 1, len);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }

    //3、DFS  对比回溯算法
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }

        // 剪枝
        if (left < right) {
            return;
        }

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

}
