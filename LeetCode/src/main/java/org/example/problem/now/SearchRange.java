package org.example.problem.now;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int leftLimit = binarySearch(nums, target, true);
        int rightLimit = binarySearch(nums, target, false) - 1;

        if (leftLimit <= rightLimit && leftLimit < nums.length && rightLimit < nums.length && nums[leftLimit] == target && nums[rightLimit] == target) {
            return new int[]{leftLimit, rightLimit};
        }

        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target || (lower && nums[mid] == target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
