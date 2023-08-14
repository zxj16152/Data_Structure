package com.solution.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Date 2022/6/29 20:14
 * @Created by ZHOUXINJIAN3
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        List<List<Integer>> subsets = solution2.subsets(new int[]{
                1, 2, 3
        });
        System.out.println(subsets);
    }

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        int i=start;
        while (i < nums.length) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
            i++;
        }
    }
}
