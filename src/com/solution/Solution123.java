package com.solution;

import java.util.*;

/**
 * @Description
 * @Date 2023/8/9 15:12
 * @Created by ZHOUXINJIAN3
 */
public class Solution123 {
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++step;
            for (int i = 0; i < size; i++) {
                String start = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return step + 1;
                    }
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            ++count;
            for (int i = 0; i < size; ++i) {
                String start = queue.poll();
                for (String s : wordList) {
                    // 已经遍历的不再重复遍历
                    if (visited.contains(s)) {
                        continue;
                    }
                    // 不能转换的直接跳过
                    if (!canConvert(start, s)) {
                        continue;
                    }
                    // 用于调试
                    // System.out.println(count + ": " + start + "->" + s);
                    // 可以转换，并且能转换成 endWord，则返回 count
                    if (s.equals(endWord)) {
                        return count + 1;
                    }
                    // 保存访问过的单词，同时把单词放进队列，用于下一层的访问
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    private boolean canConvert(String start, String s) {
        int count = 0;
        if (start.length() != s.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (start.charAt(i) != s.charAt(i)) {
                ++count;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        LinkedList<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.offer(beginWord);
        int step = 0;
        while (!q.isEmpty()) {
            ++step;
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = q.poll();
                List<String> nextWords = nextWord(currentWord, visited, wordSet);
                for (String nextWord : nextWords) {
                    System.out.println(nextWord);
                    q.add(nextWord);
                    if (nextWord.equals(endWord)) {
                        return step + 1;
                    }

                }
            }

        }

        return 0;
    }

    public List<String> nextWord(String currentWord, Set<String> visit, Set<String> wordSet) {
        List<String> nextWords = new ArrayList<>();
        char[] chars = currentWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char originChar = chars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (originChar == k) {
                    continue;
                }
                chars[i] = k;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord) && !visit.contains(nextWord)) {
                    visit.add(nextWord);
                    nextWords.add(nextWord);
                }
            }
            chars[i] = originChar;
        }
        return nextWords;
    }

    public static void main(String[] args) {
        Solution123 solution = new Solution123();
        //String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] a = {"hot", "dot", "dog", "lot", "log", "cog"};
        //int i = solution.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList(a)));
        int i = solution.ladderLength("hit", "cog", new ArrayList<>(Arrays.asList(a)));
        System.out.println(i);
    }
}
