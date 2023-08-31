package com.solution;


import java.util.LinkedList;

/**
 * 单调队列  队列存储数组索引
 */
public class MonotonicQueue {
    public MonotonicQueue(int[] nums) {
        this.nums = nums;
    }

    LinkedList<Integer> maxQ = new LinkedList<>();
    LinkedList<Integer> minQ = new LinkedList<>();
    int[] nums;

    public void pushMax(int i) {
        // 将小于 n 的元素全部删除
        while (!maxQ.isEmpty() && nums[maxQ.getLast()] <= nums[i]) {
            maxQ.pollLast();
        }
        // 然后将 n 加入尾部
        maxQ.addLast(i);
    }

    public void pushMin(int i) {
        while (!minQ.isEmpty() && nums[minQ.getLast()] >= nums[i]) {
            minQ.pollLast();
        }
        minQ.addLast(i);
    }

    public int max() {
        return maxQ.getFirst();
    }

    public int min() {
        return minQ.getFirst();
    }

    public void popMax(int i) {
        if (maxQ.getFirst() == i) {
            maxQ.pollFirst();
        }
    }


    public void popMin(int i) {
        if (minQ.getFirst() == i) {
            minQ.pollFirst();
        }
    }
}
