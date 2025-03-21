package org.example.problem.now;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 计算总和，如果是偶数才能平分
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 不是偶数，直接返回
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 数组行表示待填充背包的数组元素，列表示不同容量背包，值表示是否能填充满背包
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int element = 0; element < nums.length; element++) {
            dp[element][0] = true;
        }

        // 下面下标从1开始，元素不能重复第一个元素只有和其大小一致的背包才能填充满，先赋值第一行
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int element = 1; element < nums.length; element++) {
            for (int capacity = 1; capacity <= target; capacity++) {
                if (capacity >= nums[element]) {
                    dp[element][capacity] = (dp[element - 1][capacity] || dp[element - 1][capacity - nums[element]]);
                } else {
                    dp[element][capacity] = dp[element - 1][capacity];
                }
            }
        }

        return dp[nums.length - 1][target];
    }
}
