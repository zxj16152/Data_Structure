package com.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/14 21:14
 * @Created by ZHOUXINJIAN3
 */
public class Solution22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        //char[] chars = new char[2];
        //chars[0] = '(';
        //chars[1] = ')';
        //LinkedList<Character> track = new LinkedList();
        //backtrack(3, 0, chars, track, result);
        backtrack(0, 0, 3, new StringBuilder());
        return result;
    }

    public void backtrack(int n, int i, char[] chars, LinkedList<Character> track, List<String> result) {
        if (i == 2 * n) {
            StringBuilder s = new StringBuilder();
            for (Character character : track) {
                s.append(character);
            }
            result.add(s.toString());
            return;
        }
        for (char c : chars) {
            track.add(c);
            backtrack(n, i + 1, chars, track, result);
            track.removeLast();
        }
    }

    public void backtrack(int left, int right, int n, StringBuilder track) {
        if (left == n && right == n) {
            result.add(track.toString());
            return;
        }
        if (left < n) {
            //track.append("(");
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = track.toString().toCharArray();
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }
            backtrack(left + 1, right, n, stringBuilder.append(")"));
            //track.deleteCharAt(track.length() - 1);
        }
        if (right < left) {
            //track.append(")");
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = track.toString().toCharArray();
            for (char aChar : chars) {
                stringBuilder.append(aChar);
            }
            backtrack(left, right + 1, n, stringBuilder.append(")"));
            //track.deleteCharAt(track.length() - 1);
        }
    }


    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
        System.out.println(strings.size());
    }
}
