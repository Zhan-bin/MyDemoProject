package org.example.problem.history;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {

    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 0;
        for (int num : nums) {
            res = Math.max(res, expand(num, set));
        }

        return res;
    }

    private static int expand(int num, Set<Integer> set) {
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
