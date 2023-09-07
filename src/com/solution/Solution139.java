package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class Solution139 {
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict);

    }

    private boolean dp(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != -1) {
            return memo[i] == 1 ? true : false;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String substring = s.substring(i, i + len);
            if (!substring.equals(word)) {
                continue;
            }
            if (dp(s, i + len, wordDict)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;

    }

    public static void main(String[] args) {
        Solution139 solution = new Solution139();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = solution.wordBreak(s, wordDict);
        System.out.println(b);

    }
}
