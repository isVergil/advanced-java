package com.internship.bytedance;

/**
 * @ClassName SubStr
 * @Description TODO
 * @Author bill
 * @Date 2021/8/6 15:27
 * @Version 1.0
 * https://blog.csdn.net/weixin_42137276/article/details/106304723
 *
 * 能否在str中找到一个长度为m的连续子串，使得这个子串刚好由aim的m个字符组成，顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1
 **/
public class SubStr {
    public static void main(String[] args) {
        String a = "fdgggggert";
        String b = "gg";
        System.out.println(isSubstr(a, b));

    }


    static boolean isSubstr(String a, String b) {
        for (int i = 0; i < a.length() - b.length(); i++) {
            if (isEqual(a.substring(i, i + b.length()), b)) {
                return true;
            }
        }
        return true;
    }


    static boolean isEqual(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        //字符的ASCII范围为0-255
        int count[] = new int[256];
        for (int i = 0; i < a.length(); ++i) {
            ++count[a.charAt(i)];
        }
        for (int j = 0; j < b.length(); ++j) {
            if (count[b.charAt(j)]-- == 0) {
                return false;
            }
        }
        return true;
    }

    //给定长度为m的字符串aim，以及一个长度为n的字符串str。
    //问能否在str中找到一个长度为m的连续子串使得这个子串刚好由aim的m个字符组成，顺序无所谓。
    //返回任意满足条件的一个子串的起始位置，未找到返回-1。
    public static int getIndex(String str, String aim) {
        if (str == null || aim == null || str.length() < aim.length()) {
            return -1;
        }
        int[] count = new int[256];
        int index = 0, M = aim.length(), inVslid = 0, StrM = str.length();
        for (int i = 0; i < M; i++) {
            count[aim.charAt(i)]++;
        }
        for (; index < M; index++) {
            if (count[str.charAt(index)]-- <= 0) {
                inVslid++;
            }
        }
        for (; index < StrM; index++) {
            if (inVslid == 0) return index - M;
            if (count[str.charAt(index)]-- <= 0) inVslid++;
            if (count[str.charAt(index - M)]++ < 0) inVslid--;
        }
        return inVslid == 0 ? index - M : -1;
    }

}
