package org.example.problem.history;

import org.example.problem.common.TreeNode;

import java.util.*;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                val = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(val);
        }
        return result;
    }
}
