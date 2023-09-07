package com.solution.huawei;

import java.util.Scanner;

/**
 * 题目 根据某条件聚类最少交换次数
 * 题目说明 给出数字K，请输出所有结果小于K的整数组合到一起的最少交换次数。
 * 组合一起是指满足条件的数字相邻，不要求相邻后在数组中的位置。
 * 数据范围
 * -100 <=K <= 100
 * -100 <= 数组中数值 <= 100
 * 输入描述 第一行输入数组：1 3 1 4 0
 * 第二行输入K数值：2
 * 输出描述 第一行输出最少较好次数：1
 * 补充说明 小于2的表达式是 1 1 0，共三种可能将所有符合要求数字组合在一起，最少交换1次。
 */
public class Solution_1 {
    public static int minTimes(int[] nums, int k) {
        int minIdx = -1;
        int maxIdx = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minIdx == -1 && nums[i] < k) {
                minIdx = i;
            }
            if (nums[i] < k) {
                maxIdx = i;
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = minIdx; i <= maxIdx - count; i++) {
            int times = 0;
            for (int j = minIdx; j < minIdx + count; j++) {
                if (nums[j] >= k) {
                    times++;
                }
            }
            res = Math.min(res, times);
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        String next = scanner.nextLine();
        int k = Integer.parseInt(next);
//        int[] a = {1, 3, 5, 1, 4, 0};

        int i = minTimes(arr, k);
        System.out.println(i);
    }
}
