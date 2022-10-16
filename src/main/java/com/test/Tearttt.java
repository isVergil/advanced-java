package com.test;

/**
 * @ClassName Tearttt
 * @Description TODO
 * @Author bill
 * @Date 2022/9/19 12:12
 * @Version 1.0
 **/
public class Tearttt {

    public static void main(String[] args) {
        String str = "a";
        String str3 = "aa";
        String str1 = "aaa";
        String str2 = "aab";
        System.out.println(cal(str));
        System.out.println(cal(str1));
        System.out.println(cal(str2));
        System.out.println(cal(str3));

        System.out.println("-------------");

        int a1 = 27;
        int a2 = 703;
        int a3 = 704;
        int a4 = 1;
        System.out.println(cal1(a1));
        System.out.println(cal1(a2));
        System.out.println(cal1(a3));
        System.out.println(cal1(a4));
    }

    static int cal(String num) {
        int res = 0, len = num.length();
        for (int i = len - 1; i >= 0; i--) {
            res += (num.charAt(i) - 'a' + 1) * Math.pow(26, len - 1 - i);
        }
        return res;
    }

    static String cal1(int num) {
        if (num >= 1 && num <= 26) {
            return String.valueOf((char) (num + 'a' - 1));
        }
        StringBuilder sb = new StringBuilder();
        int pow = 26, cnt = 1;
        while (num > 0) {
            sb.append((char) (num % 26 + 'a' - 1));
            num -= Math.pow(pow, cnt++);
        }
        return sb.reverse().toString();
    }
}
