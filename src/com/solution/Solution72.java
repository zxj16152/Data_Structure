package com.solution;

import java.util.Arrays;

public class Solution72 {
    int[][] memo;

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    public int dp(String w1, int i, String w2, int j) {

        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = dp(w1, i - 1, w2, j - 1);
        } else {
            memo[i][j] = min(
                    //插入
                    dp(w1, i, w2, j - 1) + 1,
                    dp(w1, i - 1, w2, j - 1) + 1, //退换
                    dp(w1, i - 1, w2, j) + 1 //删除
            );
        }
        return memo[i][j];

    }

    public int min(int a, int b, int c) {
        return Math.min(c, Math.min(a, b));
    }

    public static void main(String[] args) {
        String s1 = "dinitrophenylhydrazine";
        String s2 = "benzalphenylhydrazone";
        Solution72 solution72 = new Solution72();
        int i = solution72.minDistance(s1, s2);
        System.out.println(i);
    }
}
