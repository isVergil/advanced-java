package com.algorithm.LeetCode热题HOT100;

/**
 * @ClassName LC79
 * @Description 79. 单词搜索
 * @Author bill
 * @Date 2022/3/27 1:09
 * @Version 1.0
 **/
public class LC79 {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (dfs(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == ' ' || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char tmp = board[row][col];
        board[row][col] = ' ';
        boolean isexist = dfs(board, word, index + 1, row + 1, col) || dfs(board, word, index + 1, row - 1, col) || dfs(board, word, index + 1, row, col + 1) || dfs(board, word, index + 1, row, col - 1);
        board[row][col] = tmp;
        return isexist;
    }

}
