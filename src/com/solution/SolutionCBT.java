package com.solution;

import java.util.LinkedList;

/**
 * 完全ercs
 */
public class SolutionCBT {
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode left = null;
        TreeNode right = null;
        //左右孩子不双全，即碰到过只有一个孩子,或者无孩子
        boolean leaf = false;

        while (queue.size() > 0) {
            TreeNode cur = queue.poll();
            left = cur.left;
            right = cur.right;
            if (right != null && left == null) {
                return false;
            }
            if (leaf && (left != null && right != null)) {
                return false;
            }

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
            if (left == null || right == null) {
                leaf = true;
            }
        }
        return true;
    }
}
