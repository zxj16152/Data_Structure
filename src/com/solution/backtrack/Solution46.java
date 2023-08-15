package com.solution.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/7 20:19
 * @Created by ZHOUXINJIAN3
 */
public class Solution46 {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, used, track);
        return res;
    }

    public void backtrack(int[] nums, boolean[] used, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, track);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        int[] a = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(a);
        System.out.println(permute);
    }
}
