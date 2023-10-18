package com.jvm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {

        List<List<Integer>> result = new ArrayList<>();
        int[] nums = {-5, -3, -2, -1, 0, 1, 2, 3, 5};
        get(nums, result);
        System.out.println(result);

    }

    public static void get(int[] nums, List<List<Integer>> result) {
        Arrays.sort(nums);

        for (int j = 0; j < nums.length; j++) {
            int sum = -nums[j];
            int left = j + 1;
            int right = nums.length - 1;
            while (left < right) {
                int target = nums[left] + nums[right];
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[j]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    break;
                } else if (target < sum) {
                    left++;
                } else if (target > sum) {
                    right--;
                }
            }
        }
    }
}






