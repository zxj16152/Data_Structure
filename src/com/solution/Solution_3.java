package com.solution;

/**
 * 长度 L的绳子覆盖坐标轴上最多的点
 */
public class Solution_3 {
    public static int sliceWindow(int[] nums, int L) {
        int left = 0, right = 0;
        int res = 0;
        int count = 0;
        while (right < nums.length - 1) {
            if (nums[right] - nums[left] <= L) {
                count++;
            }
            res = Math.max(res, count);
            while (left < right && nums[right] - nums[left] > L) {
                left++;
                count--;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6, 8, 11};
        int i = sliceWindow(a, 2);
        System.out.println(i);
    }
}
