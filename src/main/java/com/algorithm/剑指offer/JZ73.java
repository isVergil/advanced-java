package com.algorithm.剑指offer;

/**
 * @ClassName JZ73
 * @Description TODO
 * @Author bill
 * @Date 2022/2/23 13:22
 * @Version 1.0
 **/
public class JZ73 {

    public static void main(String[] args) {
        String sds = "nowcoder.   a  am  I";
        System.out.println(new JZ73().ReverseSentence(sds));
    }

    public String ReverseSentence(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        String[] strArr = str.split(" ");
        for (int i = strArr.length - 1; i >= 0; i--) {
            if (!strArr[i].equals("")) {
                sb.append(strArr[i]).append(" ");
            }

        }
        return sb.toString().trim();
    }

}
