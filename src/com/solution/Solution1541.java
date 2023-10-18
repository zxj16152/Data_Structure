package com.solution;

import java.util.Stack;

/**
 * 平衡括号字符串的最少插入次数
 */
public class Solution1541 {
    public static int minInsertions(String s) {
        int res = 0;
        int insert = 0;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            if (array[i] == '(') {
                stack.push('(');
                i++;
            } else {
                if (i + 1 < array.length && array[i + 1] == ')') {
                    i += 2;
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        insert++;
                    }

                } else {
                    if (!stack.isEmpty()) {
                        insert++;
                        stack.pop();
                    } else {
                        insert += 2;
                    }
                    i++;
                }
            }
        }

        return insert + 2 * stack.size();
    }

    public static int minInsertions1(String s) {
        int res = 0;
        int need = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            } else {
                need--;
                if (need == -1) {
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;

    }

    public static void main(String[] args) {
//        int i = minInsertions("())())");
        int i = minInsertions("()())))()");
        System.out.println(i);
    }
}
