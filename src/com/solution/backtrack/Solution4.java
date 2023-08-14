package com.solution.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/7 19:44
 * @Created by ZHOUXINJIAN3
 */
public class Solution4 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.fill(used, false);
        trackback(candidates, 0, target, track);
        return res;
    }

    public void trackback(int[] candidates, int start, int remainSum, LinkedList<Integer> track) {
        if (remainSum == 0) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (remainSum < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            track.add(candidates[i]);
            trackback(candidates, i + 1, remainSum - candidates[i], track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();

        int[] a = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(a, 8);
        System.out.println(lists);
    }

}
