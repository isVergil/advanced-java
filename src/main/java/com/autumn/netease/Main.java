package com.autumn.netease;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/9/4 15:26
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        cal(7);
        cal(4);
    }

    static void cal(int num) {
        int l = 1, r = num;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (cal(num, mid) < cal(num, mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        //分子
        System.out.println(Math.pow(num, l));
        //分母
        System.out.println(Math.pow(l, l));
    }

    //计算乘积
    static double cal(int num, int n) {
        return Math.pow(num / 1.0 / n, n);
    }


}
