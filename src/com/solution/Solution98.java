package com.solution;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return process(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean validBST2 = isValidBST2(root.left);
        if (!validBST2) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }


    public boolean process(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if (root.val < low || root.val > high) {
            return false;
        }
        return process(root.left, low, root.val) && process(root.right, root.val, high);

    }
}
