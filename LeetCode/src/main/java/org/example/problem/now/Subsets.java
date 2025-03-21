package org.example.problem.now;

import java.util.*;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        dfs(nums, index + 1, list, result);
        list.add(nums[index]);
        dfs(nums, index + 1, list, result);
        list.remove(list.size() - 1);
    }
}
