package com.solution;


/**
 *
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int begin = 0;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                end = i;
            } else if (nums[i] >= max) {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                begin = len - 1 - i;
            } else if (nums[len - 1 - i] <= min) {
                min = nums[len - 1 - i];
            }
        }
        return end - begin + 1;
    }
}
