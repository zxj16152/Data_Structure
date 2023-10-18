package com.solution;

import java.util.Stack;

/**
 * 有效括号
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                left.push(c);
            } else {
                if (!left.isEmpty() && leftOf(c) == left.peek()) {
                    left.pop();
                } else {
                    return false;
                }
            }
        }
        return left.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        }
        return '{';
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean valid = solution20.isValid("]");
        System.out.println(valid);
    }
}
