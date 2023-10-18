package com.solution;

/**
 * 845. 数组中的最长山脉
 */
public class Solution845 {
    public static int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i;
            int right = i;
            int res = 0;
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
                    left--;
                    res++;
                }
                while (right < arr.length - 1 && arr[right + 1] < arr[right]) {
                    right++;
                    res++;
                }
                result = Math.max(res, result);
            }
        }
        return result == 0 ? 0 : result + 1;
    }

    public static int longestMountain2(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        for (int i = 1; i < arr.length - 1; i++) {
            left[i] = arr[i] > arr[i - 1] ? left[i - 1] + 1 : 0;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = arr[i] > arr[i + 1] ? right[i + 1] + 1 : 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (left[i] > 0 && right[i] > 0) {
                res = Math.max(res, left[i] + right[i] + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2, 2, 2};
        int i = longestMountain2(a);
        System.out.println(i);
    }
}
