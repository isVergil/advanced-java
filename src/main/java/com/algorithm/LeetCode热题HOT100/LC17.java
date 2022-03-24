package com.algorithm.LeetCode热题HOT100;

import java.util.*;

/**
 * @ClassName LC17
 * @Description 17. 电话号码的字母组合
 * @Author bill
 * @Date 2022/3/17 14:32
 * @Version 1.0
 **/
public class LC17 {

    String[] nums = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    List<String> res;

    StringBuilder sb;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList();
        sb = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    public void backtrack(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = nums[digit];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
