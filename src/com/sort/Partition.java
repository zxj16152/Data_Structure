package com.sort;

import java.util.Arrays;

/**
 * 数据分开，将数组中数和某个数比较，分为小于区域，等于区域，大于区域
 * https://www.bilibili.com/video/BV13g41157hK?p=4&vd_source=5e8bdc2c275fc8aaedd999a49f96ad32
 */
public class Partition {
    //i 为小于target 的最后的数的索引
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

    // num[k]<target num[k] 和小于target 区域下一个数交换，
    // num[k]==target k++;
    //num[k]>target num[k] 和大于target 区域的下一个数交换，k不变，因为交换过来的数没有比较是否小于target
    public static void part2(int[] nums, int target) {
        //i 为小于target 的最后的数的索引
        int i = -1;
        //j 为大于target 的最后的数的索引
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
        part2(a, 5);
        System.out.println(Arrays.toString(a));
    }
}
