package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC76
 * @Description 76. 最小覆盖子串
 * @Author bill
 * @Date 2022/3/25 14:09
 * @Version 1.0
 **/
public class LC76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        //定义字符数组,注意保存的字符相等于下标i,比如保存了'A',相当于need[65] = 1
        int[] need = new int[128];
        //保存所需要的字符个数,也即对应的ASCII码作为下标的值
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l左边界,r右边界,size有效窗口大小,count需要字符个数,start为有效窗口的开始下标
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//说明该字符我们需要
                count--;
            }
            //这里将r遍历的字符都加入到了窗口中,如果是无关的字符会变成负数
            //如果是需要的字符就会减一,出现多余的也会变成负数
            need[c]--;
            if (count == 0) {//说明区间已经拿到了所有需要的字符
                //这里有两种情况,一种是区间不需要的字符,还有一种是重复的需要字符
                //总之就是去掉冗余的字符,缩小区间
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;
                }
                if (r - l + 1 < size) {//更新有效区间的最小值
                    size = r - l + 1;
                    start = l;
                }
                //将左边界右移,由于减少了一位需要的字符,所以都要加1
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            //右边界右移
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    //while(l<r&&need[s.charAt(l)]<0) { need[s.charAt(l)]++; l++; }
    //这一段是最难理解的一段，去掉不必要的字符。 这里有两种情况,一种是区间不需要的字符,
    //总之就是去掉冗余的字符,缩小区间 need[s.charAt(l)]++这个是干什么用的，对，就是去掉重复的需要字符。
    //在右指针扫描的时候，会把重复的需要的字符标记成不需要的，所以这里就是恢复需要字符的身份。
}
