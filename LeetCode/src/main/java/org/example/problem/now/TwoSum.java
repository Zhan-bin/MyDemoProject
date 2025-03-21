package org.example.problem.now;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.getOrDefault(target - nums[i], null);
            if (index != null) {
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
