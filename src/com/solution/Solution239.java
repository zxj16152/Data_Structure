package com.solution;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * @See com.solution.MonotonicQueue
 */
public class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return null;
        }

        LinkedList<Integer> qMax = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            if (qMax.peekFirst() <= i - k) {
                qMax.pollFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                res[index++] = nums[qMax.peekFirst()];
            }

        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }


    public static int[] maxSlidingWindow3(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue(nums);
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.pushMax(i);
            } else {
                queue.pushMax(i);
                res[index++] = nums[queue.max()];
                queue.popMax(i - k + 1);
            }
        }
        return res;
    }

    public static int[] minSlidingWindow3(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue(nums);
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.pushMin(i);
            } else {
                queue.pushMin(i);
                res[index++] = nums[queue.min()];
                queue.popMin(i - k + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 2, 1, 4, 3, 5};
        int[] ints = minSlidingWindow3(a, 3);
        System.out.println(Arrays.toString(ints));
    }
}
