package com.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.sort.Partition.swap;

/**
 * 最长连续子序列
 */
public class Solution128 {
    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }

            int curLen = 1;
            while (set.contains(num + 1)) {
                num = num + 1;
                curLen += 1;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        removeSameNum(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void removeSameNum(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                swap(nums, fast, slow);
            }
            fast++;
        }
    }


}
