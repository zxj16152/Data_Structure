package com.sort;

import java.util.Arrays;

/**
 * @Description
 * @Date 2023/8/10 14:07
 * @Created by ZHOUXINJIAN3
 */
public class QuickSort {
    public void sort(int[] nums) {

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public static int[] partition0(int[] nums, int left, int right) {
        int less = left - 1; //小于区域右边界
        int more = right;//大于区域左边界
        while (left < more) {
            if (nums[left] < nums[right]) {
                swap(nums, ++less, left++);
            } else if (nums[left] > nums[right]) {
                swap(nums, --more, left);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    public static int[] myPartition0(int[] nums, int left, int right) {
        int pivot = nums[right];
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (nums[left] < pivot) {
                left++;
                swap(nums, ++less, left);
            } else if (nums[left] > pivot) {
                swap(nums, --more, left);
            } else {
                left++;
            }
        }
        swap(nums, more, right);
        return null;
    }


    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        //小于区域
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, ++index, right);
        return index;
    }


    public static int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && nums[r] >= pivot) {
                r--;
            }
            while (l < r && nums[l] <= pivot) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        nums[left] = nums[l];
        nums[l] = pivot;
        return l;
    }

    public static int partition3(int[] nums, int left, int right) {
        int l = left, r = right;
        int pivot = nums[(left + right) / 2];
        while (l <= r) {
            while (nums[l] < pivot) {
                l++;
            }
            while (nums[r] > pivot) {
                r--;
            }
            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] a = {8, 3, 1, 10, 2, 7, 6, 9, 4};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }


    private static void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
