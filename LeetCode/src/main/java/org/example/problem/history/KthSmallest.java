package org.example.problem.history;

import org.example.problem.common.TreeNode;

public class KthSmallest {
    int step = 1;
    int result;
    int n;

    public int kthSmallest(TreeNode root, int k) {
        n = k;
        kthSmallest(root);
        return result;
    }

    private void kthSmallest(TreeNode root) {
        // n < step说明已经找到结果，直接返回，实现剪枝
        if (root == null || n < step) {
            return;
        }
        kthSmallest(root.left);
        if (n >= step) {
            result = root.val;
        }
        step++;
        kthSmallest(root.right);
    }
}
