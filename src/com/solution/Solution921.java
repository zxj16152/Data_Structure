package com.solution;

import java.util.Stack;

/**
 * 使括号有效的最少添加
 * 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
 */
public class Solution921 {
    public int minAddToMakeValid(String s) {
        int res = 0;
        int need = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                need++;
            }
            if (chars[i] == ')') {
                need--;
                if (need == -1) {
                    //插入一个左括号
                    res++;
                    //need  复位
                    need = 0;
                }
            }

        }
        return res + need;
    }

    public int minAddToMakeValid1(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    res++;
                }
            }
        }
        while (!stack.isEmpty()) {
            stack.pop();
            res++;
        }
        return res;
    }
}
