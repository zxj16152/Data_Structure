package com.solution.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/4 16:11
 * @Created by ZHOUXINJIAN3
 */
public class Solution {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    //public List<List<Integer>> subsets(int[] nums) {
    //    backtrack(nums, 0);
    //    return res;
    //}
    //
    //public void backtrack(int[] nums, int start) {
    //    for (int i = start; i < nums.length; i++) {
    //        track.addLast(nums[i]);
    //        backtrack(nums, i + 1);
    //        track.removeLast();
    //    }
    //    res.add(new LinkedList<>(track));
    //}


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n);
        return res;
    }

    public void backtrack(int num, int remainCount, int remainSum) {
        if (remainCount == 0) {
            if (remainSum == 0) {
                res.add(new LinkedList<>(track));
            }
        } else {
            for (int i = num; i <= 9 && i <= remainSum; i++) {
                track.addLast(i);
                backtrack(i + 1, remainCount - 1, remainSum - i);
                track.removeLast();
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3};
        List<List<Integer>> subsets = solution.combinationSum3(3, 7);
        System.out.println(subsets);
    }
}
