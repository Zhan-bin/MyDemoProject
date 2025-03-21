package org.example.problem.history;

public class FindMin {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1, mid;
        // 没有旋转的数组直接输出结果
        if (nums[start] < nums[end] || nums.length == 1) {
            return nums[start];
        }

        // 二分查找结果总是在无序的那一边，注意nums[0] < nums[mid]
        while (start <= end) {
            mid = (start + end + 1) >> 1;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[0] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
