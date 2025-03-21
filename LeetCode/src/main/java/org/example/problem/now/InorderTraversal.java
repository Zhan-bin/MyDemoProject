package org.example.problem.now;

import org.example.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }
}
