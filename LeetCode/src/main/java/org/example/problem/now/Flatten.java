package org.example.problem.now;

import org.example.problem.common.TreeNode;

public class Flatten {
    public void flatten(TreeNode root) {
        for (TreeNode node = root; node != null; node = node.right) {
            if (node.left == null) {
                continue;
            }

            TreeNode right = node.left;
            while (right.right != null) {
                right = right.right;
            }

            right.right = node.right;
            node.right = node.left;
            node.left = null;
        }
    }
}
