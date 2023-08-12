package com.sort;

import java.util.Arrays;

public class Partition {
    public static void part(int[] nums, int target) {
        int i = -1;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] <= target) {
                swap(nums, j, ++i);
            }
            j++;
        }
    }

    public static void part2(int[] nums, int target) {
        int i = -1;
        int j = nums.length;
        int k = 0;
        while (k < j) {
            if (nums[k] < target) {
                swap(nums, k, ++i);
                k++;
            } else if (nums[k] > target) {
                swap(nums, k, --j);
            } else if (nums[k] == target) {
                k++;
            }
        }

    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {1, 7, 5, 2, 6, 3, 5, 2};
        part(a, 5);
        System.out.println(Arrays.toString(a));
    }
}
