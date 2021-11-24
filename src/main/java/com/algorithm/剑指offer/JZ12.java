package com.algorithm.剑指offer;

/**
 * @ClassName JZ11
 * @Description TODO
 * @Author bill
 * @Date 2021/8/29 14:46
 * @Version 1.0
 **/
/*
矩阵中的路径

给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JZ12 {

    //回溯 + DFS
    char[][] board;
    char[] word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(int i, int j, int k) {
        //board[i][j] != word[k] 要放到最后 以防止数组越界
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        //设置找过的元素为 空 防止再取
        board[i][j] = ' ';
        boolean res = dfs(i + 1, j, k + 1) || dfs(i - 1, j, k + 1) ||
                dfs(i, j + 1, k + 1) || dfs(i, j - 1, k + 1);
        //恢复
        board[i][j] = word[k];
        return res;
    }
}
