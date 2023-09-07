package com.solution;

/**
 * n个苹果 ，有两种 袋子，每个袋子刚好装6个和8个，求最小袋子数，不能刚好装完返回-1；
 */
public class Solution_4 {
    public static int justNum(int n) {

        return dp(n);
    }

    public static int dp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 6 || n == 8) {
            return 1;
        }
        if (n < 6 || n == 7) {
            return -1;
        }
        int dp8 = dp(n - 8);
        int dp6 = dp(n - 6);
        if (dp6 != -1 && dp8 != -1) {
            return Math.min(dp(n - 8), dp(n - 6)) + 1;
        }
        if (dp6 == -1 && dp8 == -1) {
            return -1;
        }
        if (dp6 == -1) {
            return dp8 + 1;
        }
        if (dp8 == -1) {
            return dp6 + 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int i = justNum(24);
        System.out.println(i);
    }
}
