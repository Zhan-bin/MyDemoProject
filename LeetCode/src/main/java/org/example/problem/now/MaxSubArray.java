package org.example.problem.now;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSubArrSum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            maxSubArrSum = Math.max(maxSubArrSum, sum);
        }

        return maxSubArrSum;
    }
}
