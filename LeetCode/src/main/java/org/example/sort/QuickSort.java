package org.example.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 9, 8, 4, 1, 5};

        QuickSort sort = new QuickSort();
        sort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int partition = partition(nums, start, end);
        sort(nums, start, partition - 1);
        sort(nums, partition + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int target = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= target) {
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < target) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = target;
        return start;
    }
}
