package com.solution;

import java.util.Arrays;

import static com.sort.Partition.swap;

public class RepeateNumber {
    public static int[] test(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                swap(nums, slow, fast);
            }
            fast++;
        }
        return Arrays.copyOf(nums, slow);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3, 4};

//        1  2
        int[] test = test(a);
        System.out.println(Arrays.toString(test));
        int b = 3;
        System.out.println(b >> 1);
        System.out.println(b);
//        Integer.lowestOneBit()
        System.out.println(Integer.toBinaryString(-2));
        "abc".indexOf("cddff");
    }
}
