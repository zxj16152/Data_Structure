package com.solution;

/**
 *
 */
public class Solution330 {
    // 1,2,4,8,16,.....能表示任何数
    public static int minPatches(int[] nums, int n) {
        long cur = 1;
        int index = 0;
        int count = 0;
        while (cur <= n) {
            if (index >= nums.length || nums[index] > cur) {
                count++;
                cur = cur << 1;
            } else {
                cur = cur + nums[index++];
            }
        }
        return count;
    }
}
