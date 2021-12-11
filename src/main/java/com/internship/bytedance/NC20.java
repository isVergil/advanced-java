package com.internship.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NC20
 * @Description TODO
 * @Author bill
 * @Date 2021/12/4 10:49
 * @Version 1.0
 **/
/*
数字字符串转化成IP地址

https://www.nowcoder.com/practice/ce73540d47374dbe85b3125f57727e1e?tpId=188&&tqId=38663&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 */
public class NC20 {
    //法1 暴力枚举
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if (a + b + c + d == s.length()) {
                            String a1 = s.substring(0, a);
                            String b1 = s.substring(a, a + b);
                            String c1 = s.substring(a + b, a + b + c);
                            String d1 = s.substring(a + b + c, s.length());
                            if (check(a1) && check(b1) && check(c1) && check(d1)) {
                                res.add(a1 + "." + b1 + "." + c1 + "." + d1);
                            }
                        }

                    }
                }
            }
        }
        return res;
    }

    boolean check(String str) {
        if (Integer.valueOf(str) <= 255) {
            if (str.charAt(0) != '0' || str.charAt(0) == '0' && str.length() == 1) {
                return true;
            }
        }
        return false;
    }

    //法2 回溯法
    //https://programmercarl.com/0093.%E5%A4%8D%E5%8E%9FIP%E5%9C%B0%E5%9D%80.html#java
    List<String> res;

    public List<String> restoreIpAddresses1(String s) {
        res = new ArrayList();
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backtrace(new StringBuilder(s), 0, 0);
        return res;
    }

    void backtrace(StringBuilder s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length() && i - startIndex < 3; i++) {
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, ".");
                pointNum++;
                backtrace(s, i + 2, pointNum);
                pointNum--;
                s.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    //判断 字符在 左闭 右闭 区间内是否数字字符合法
    boolean isValid(StringBuilder s, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return false;
        }
        if (s.charAt(startIndex) == '0' && startIndex != endIndex) {
            return false;
        }
        if (Integer.valueOf(s.toString().substring(startIndex, endIndex + 1)) > 255) {
            return false;
        }
        return true;
    }
}
