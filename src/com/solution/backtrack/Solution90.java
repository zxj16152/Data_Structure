package com.solution.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/7 20:41
 * @Created by ZHOUXINJIAN3
 */
public class Solution90 {


    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, 0, track);
        return res;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> track) {
        if (track.size() > nums.length) {
            return;
        }
        if (track.size() <= nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution90 solution = new Solution90();
        int[] a = {1, 2, 2};
        List<List<Integer>> lists = solution.subsetsWithDup(a);
        System.out.println(lists);
    }
}
