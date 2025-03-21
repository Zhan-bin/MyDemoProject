package org.example.problem.history;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i + 1) {
                if (nums[nums[i] - 1] == nums[i]) {
                    return nums[i];
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
