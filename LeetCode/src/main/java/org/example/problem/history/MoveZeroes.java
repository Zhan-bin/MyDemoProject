package org.example.problem.history;

public class MoveZeroes {
    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                step++;
                continue;
            }

            nums[i - step] = nums[i];
        }

        int len = nums.length;
        for (int i = 1; i <= step; i++) {
            nums[len - i] = 0;
        }
    }
}
