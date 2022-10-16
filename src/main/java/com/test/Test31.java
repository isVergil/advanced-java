package com.test;

/**
 * @ClassName Test31
 * @Description TODO
 * @Author bill
 * @Date 2022/8/25 20:04
 * @Version 1.0
 **/
public class Test31 {

    public static void main(String[] args) {
        System.out.println(removeDigit("15958", '5'));
        System.out.println(removeDigit("-15958", '5'));
        System.out.println(removeDigit("-58895", '5'));
        System.out.println(removeDigit("-5000", '5'));
    }

    static String removeDigit(String number, char digit) {
        String res = "";
        int start = 0;
        boolean flag = true;
        if (number.charAt(0) == '-') {
            start = 1;
            flag = false;
        }
        int len = number.length();
        for (int i = start; i < len; i++) {
            if (number.charAt(i) == digit) {
                String cur = number.substring(start, i) + number.substring(i + 1, len);
                if (flag) {
                    if (cur.compareTo(res) > 0) {
                        res = cur;
                    }
                } else {
                    if (res == "") {
                        res = cur;
                    }
                    if (cur.compareTo(res) < 0) {
                        res = cur;
                    }
                }

            }
        }
        if (Integer.valueOf(res) == 0) {
            return "0";
        }
        return flag ? res : "-" + res;
    }
}
