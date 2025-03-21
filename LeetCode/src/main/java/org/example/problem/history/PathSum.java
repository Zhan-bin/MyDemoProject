package org.example.problem.history;

import org.example.problem.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum {
    Map<Long, Integer> prefixSumMap = new HashMap<>();
    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        prefixSumMap.put(0L, 1);
        pathSum(root, targetSum, 0);

        return count;
    }

    public void pathSum(TreeNode root, int targetSum, long prefixSum) {
        if (root == null) return;

        long sum = prefixSum + root.val;
        prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0) + 1);
        pathSum(root.left, targetSum, sum);
        pathSum(root.right, targetSum, sum);
        prefixSumMap.put(sum, prefixSumMap.get(sum) - 1);

        count += prefixSumMap.getOrDefault(sum - targetSum, 0);
    }
}
