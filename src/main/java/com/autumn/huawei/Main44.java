package com.autumn.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main44
 * @Description TODO
 * @Author bill
 * @Date 2022/9/21 19:29
 * @Version 1.0
 **/
public class Main44 {

    // 将长N*M厘米的矩形区域划分成N行M列（每行每列的宽度均为1厘米），在第i行第j列的位置上叠放Ai,j个边长为1厘米的正方体（1≤Ai,j≤100），所有正方体就组成了一个立体图形，每个正方体六个面中的一部分会被其它正方体遮挡，未被遮挡的部分的总面积即为该立体图形的表面积，那么该立体图形的表面积是多少平方厘米？
    //
    // 样例解释：
    //
    // 小A的英语考了个不及格，老师很生气，并且发现他英语的语法几乎全错！于是老师决定好好教教他英语语法。
    //
    // 老师想先从句子结构开始教他。一个句子至少需要包含主谓结构，即主语和谓语，并且主语在前，谓语在后。有些句子会在谓语后面加上宾语。避免复杂，本题中句子的顺序严格按照主语-谓语-宾语的顺序（即无宾语前置和倒装等情况）。
    //
    // 老师给了小A三张单词表，分别是主语单词表、谓语单词表和宾语单词表。老师要让小A用这些单词表中的单词来造句，并且规定：谓语有且仅有一个单词，主语和宾语可以包含任意个单词（主语不可为空）。老师暂时不想让小A造出能保证意思通顺的句子，他只想让小A能够学会基本的句子结构就行。
    //
    // 现在，小A根据这些单词造了m条句子，现在假设你是老师，你需要判断每条句子是否符合上述句子结构。

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] rowMax = new int[n];
        Arrays.fill(rowMax, 1);
        int[] colMax = new int[m];
        Arrays.fill(colMax, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cur = sc.nextInt();
                rowMax[i] = Math.max(rowMax[i], cur);
                colMax[j] = Math.max(colMax[j], cur);
            }
        }
        //6个面
        //上 底
        int s = n * m;
        //左 右 行最大值
        for (int i = 0; i < n; i++) {
            s += rowMax[i];
        }
        //前 后 列最大值
        for (int i = 0; i < m; i++) {
            s += colMax[i];
        }
        System.out.println(s * 2);
    }


}
