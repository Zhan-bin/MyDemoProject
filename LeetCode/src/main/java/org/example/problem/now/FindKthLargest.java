package org.example.problem.now;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = findKthLargest.findKthLargest(nums, 3);
        System.out.println(k);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return -1;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });


        for (int num : nums) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek() < num) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            } else {
                priorityQueue.offer(num);
            }
        }

        return priorityQueue.isEmpty() ? -1 : priorityQueue.peek();
    }
}
