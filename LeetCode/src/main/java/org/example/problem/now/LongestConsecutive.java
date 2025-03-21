package org.example.problem.now;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longestConsecutive = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        /**
         * 计算过的起点不用重复计算，直接遍历Set，相当于先帮我们去重了，减少重复判断
         */
        for (int num : set) {
            longestConsecutive = Math.max(expand(num, set), longestConsecutive);
        }

        return longestConsecutive;
    }

    private int expand(int num, Set<Integer> set) {
        if (set.contains(num - 1)) {
            return 0;
        }

        int max = num + 1;
        while (set.contains(max)) {
            max++;
        }

        return max - num;
    }
}
