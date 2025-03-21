package org.example.problem.history;

/**
 * 0 * b c d
 * 1 a * c d
 * 2 a b * d
 * 3 a b c *
 *
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return null;
        }

        int len = nums.length;
        int[] result = new int[len];

        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        for (int i = len - 2; i >=0; i--) {
            tmp *= nums[i + 1];
            result[i] *= tmp;
        }

        return result;
    }
}
