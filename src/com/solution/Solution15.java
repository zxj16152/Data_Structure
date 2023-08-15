package com.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Date 2023/8/14 19:23
 * @Created by ZHOUXINJIAN3
 */
public class Solution15 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int otherSum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int leftValue = nums[left];
                int rightValue = nums[right];
                if (leftValue + rightValue < otherSum) {
                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }
                } else if (leftValue + rightValue > otherSum) {
                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }

                } else if (leftValue + rightValue == otherSum) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }
                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int sz = nums.length;
        if (n < 2 || sz < n) return res;
        if (n == 2) {
            int lo = start, hi = sz - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                int left = nums[lo];
                int right = nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(new ArrayList<>(Arrays.asList(left, right)));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        } else {
            for (int i = start; i < sz; i++) {
                int value = nums[i];
                List<List<Integer>> subResults = nSumTarget(nums, n - 1, i + 1, target - value);
                for (List<Integer> subResult : subResults) {
                    subResult.add(value);
                    res.add(subResult);

                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> lists = solution.nSumTarget(nums, 3, 0, 0);
        System.out.println(lists);
    }
}
