package org.example.problem.now;

public class Search {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[0]) {  // 左边有序, 易错，应该是>=而不是>，错误的case [3,1]，需要考虑left和mid相等的情况。
                if (nums[mid] > target && nums[0] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
