package org.example.problem.now;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                offset++;
                continue;
            }
            nums[i - offset] = nums[i];
        }

        while (offset > 0) {
            nums[nums.length - offset] = 0; // 易错
            offset--;
        }
    }
}
