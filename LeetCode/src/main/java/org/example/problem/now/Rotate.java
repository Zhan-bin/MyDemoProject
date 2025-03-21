package org.example.problem.now;

public class Rotate {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int step = k % len;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            temp[(i + step) % len] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, len);
    }
}
