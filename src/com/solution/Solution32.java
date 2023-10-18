package com.solution;

import java.util.Stack;

public class Solution32 {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    dp[i + 1] = 0;
                } else {
                    Integer leftIndex = stack.pop();
                    int len = dp[leftIndex] + i - leftIndex + 1;
                    dp[i + 1] = len;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
