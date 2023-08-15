package com.solution.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//八皇后
class Solution3 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] re : board) {
            Arrays.fill(re, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public List charToList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToList(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        //左上方
        for (int i = row - 1, j = col - 1; i >= 0 & j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        //右上方
        for (int i = row - 1, j = col + 1; i >= 0 & j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
