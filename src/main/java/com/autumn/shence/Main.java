package com.autumn.shence;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author bill
 * @Date 2022/10/13 19:11
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(ipv72Int(sc.nextLine()));
        }

    }

    static long ipv72Int(String str) {
        if (str == null || str.length() < 13 || str.charAt(0) == '.' || str.charAt(str.length() - 1) == '.') {
            return -1;
        }
        String[] ips = str.split("\\.");
        if (ips.length != 7) {
            return -1;
        }
        long res = 0;
        try {
            for (int i = 0; i < 7; i++) {
                if (ips[i] == null || ips[i] == "") {
                    continue;
                }
                long cur = Integer.parseInt(ips[i]);
                if (ips[i].length() == 0 || (cur == 0 && i != 0)) {
                    continue;
                } else if (cur > 225 || cur <= 0) {
                    return -1;
                }
                res += (cur << (ips.length - 1 - i) * 8);

            }
        } catch (Exception e) {
            return -1;
        }

        return res;
    }

}
