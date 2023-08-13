package com.solution;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution662 {

    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(1, root.left, root.right));
        int res = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            int startIndex = -1;
            int endIndex = -1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (startIndex == -1) {
                    startIndex = cur.val;
                }
                endIndex = cur.val;
                if (cur.left != null) {
                    queue.offer(new TreeNode(cur.val * 2, cur.left.left, cur.left.right));
                }
                if (cur.right != null) {
                    queue.offer(new TreeNode(cur.val * 2 + 1, cur.right.left, cur.right.right));
                }
                res = Math.max(res, endIndex - startIndex + 1);
            }
        }
        return res;
    }

    Map<Integer, Integer> levelMinIndexMap = new HashMap<>();
    int res = 0;

    public void dfs(TreeNode cur, int nodeIndex, int level) {
        if (cur == null) {
            return;
        }
        levelMinIndexMap.putIfAbsent(level, nodeIndex);
        res = Math.max(res, nodeIndex - levelMinIndexMap.get(level) + 1);
        dfs(cur.left, nodeIndex * 2, level + 1);
        dfs(cur.right, nodeIndex * 2 + 1, level + 1);
    }
}
