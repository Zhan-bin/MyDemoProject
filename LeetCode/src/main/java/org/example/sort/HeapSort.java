package org.example.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 9, 8, 4, 1, 5};

        HeapSort sort = new HeapSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        // 1. 构建大顶堆
        generateMaxHeap(nums);

        // 2. 不断调整堆，将最大元素移动到根节点，然后移动到数组尾部
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);  // 生成大顶堆的时候已经排好一个元素，直接交换，最后一个排的是位置0的，无需交换元素。
            adjustHeap(nums, 0, i);
        }
    }

    private void adjustHeap(int[] nums, int index, int length) {
        int leftChildIndex = leftChildIdx(index), rightChildIndex = rightChildIdx(index), largestIndex = index;
        if (leftChildIndex < length && nums[leftChildIndex] > nums[largestIndex]) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < length && nums[rightChildIndex] > nums[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(nums, largestIndex, index);
            adjustHeap(nums, largestIndex, length);
        }
    }

    private void generateMaxHeap(int[] nums) {
        for (int i = lastNonLeafNodeIdx(nums.length); i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    private int lastNonLeafNodeIdx(int length) {
        return length / 2 - 1;
    }

    public int leftChildIdx(int index) {
        return index * 2 + 1;
    }

    public int rightChildIdx(int index) {
        return index * 2 + 2;
    }
}
