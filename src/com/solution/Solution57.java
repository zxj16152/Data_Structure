package com.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Solution57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int length = intervals.length;
        int end = newInterval[1];
        int start = newInterval[0];
        int i = 0;
        while (i < length && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }
        while (i < length && intervals[i][0] <= end) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);
        while (i < length) {
            result.add(intervals[i]);
            i++;
        }
        int[][] res = new int[result.size()][2];
        for (int i1 = 0; i1 < result.size(); i1++) {
            res[i1] = result.get(i1);
        }
        return res;
    }


}
