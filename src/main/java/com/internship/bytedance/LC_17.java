package com.internship.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LC_17
 * @Description TODO
 * @Author bill
 * @Date 2021/12/9 13:50
 * @Version 1.0
 **/
/*
电话号码的字母组合
回溯法
 */
public class LC_17 {

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
    StringBuilder s;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<String>();
        s = new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(digits, 0);
        return res;
    }

    public void backtrack(String digits, int index) {
        if (index == digits.length()) {
            res.add(s.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letters = nums[digit];
        for (int i = 0; i < letters.length(); i++) {
            s.append(letters.charAt(i));
            backtrack(digits, i + 1);
            s.deleteCharAt(s.length() - 1);
        }

    }
}
