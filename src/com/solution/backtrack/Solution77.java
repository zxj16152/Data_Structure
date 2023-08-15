package com.solution.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/7 20:32
 * @Created by ZHOUXINJIAN3
 */
public class Solution77 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(k, n, 1, track);
        return res;
    }

    public void backtrack(int k, int n, int start, LinkedList<Integer> track) {
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(k, n, i + 1, track);
            track.removeLast();
        }
    }
}
