package com.sort;

import java.util.Arrays;

public class BucketSort {
    public static int getMaxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max = max / 10;
        }
        return res;
    }

    public static void bucketSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        bucketSort(arr, 0, arr.length - 1, getMaxBits(arr));
    }

    public static void bucketSort(int[] arr, int L, int R, int digit) {
        int radix = 10;
        int i = 0;
        int j = 0;
        int[] helpArr = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (int k = L; k <= R; k++) {
                j = getDigit(arr[k], d);
                count[j]++;
            }
            //前缀和
            for (int k = 1; k < radix; k++) {
                count[k] = count[k] + count[k - 1];
            }
            for (int k = R; k >= L; k--) {
                j = getDigit(arr[k], d);
                helpArr[count[j] - 1] = arr[k];
                count[j]--;
            }
            for (j = 0, i = L; i <= R; i++, j++) {
                arr[i] = helpArr[j];
            }

        }

    }

    public static void main(String[] args) {
        int[] arr = {123, 456, 214, 243, 156, 124};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int getDigit(int x, int d) {
        double pow = Math.pow(10, d - 1);
        return (x / (int) pow) % 10;
    }
}
