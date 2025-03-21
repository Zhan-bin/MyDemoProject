package org.example.problem.history;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return findKthLargest(nums, 0, nums.length, index);
    }

    public int findKthLargest(int[] nums, int start, int end, int index) {
        if (start > end) {
            return -1;
        }

        int partition = partition(nums, start, end);
        if (partition == index) {
            return nums[index];
        } else if (partition < index) {
            return findKthLargest(nums, partition + 1, end, index);
        } else {
            return findKthLargest(nums, start, partition - 1, index);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int key = nums[start];
        while (start < end) {
            while (start < end && key >= nums[end]) {
                end--;
            }
            nums[start] = nums[end];
            while (start <end && key < nums[start]) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = key;
        return start;
    }
}
