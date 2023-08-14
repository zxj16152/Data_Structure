package com.sort;

/**
 * @Description
 * @Date 2023/8/10 14:07
 * @Created by ZHOUXINJIAN3
 */
public class QuickSort {
    public void sort(int[] nums) {

    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index, right);
        return index;
    }

    private void swap(int[] nums, int i, int index) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
