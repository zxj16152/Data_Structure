package com.solution;

public class Solution334 {
    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (nums[i] < mid && nums[i] > small) {
                mid = nums[i];
            }
            if (nums[i] > mid) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 1, 6};
        boolean b = increasingTriplet(a);
        System.out.println(b);
    }
}
