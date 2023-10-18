package com.solution;

import java.util.Arrays;

public class Main {
    public static int[] get(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (queries[i] < sum) {
                    answers[i] = j;
                    break;
                } else {
                    answers[i] = j + 1;
                }
            }
        }
        return answers;
    }


    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] ints = get(nums, queries);
        System.out.println(Arrays.toString(ints));
    }


}
