package org.example.problem.now;

import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int numsLen = nums.length;
        int[] result = new int[numsLen - k + 1];
        int p = 1 - k;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numsLen; i++, p++) {
            if (p > 0 && nums[p - 1] == queue.getFirst()) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                queue.removeLast();
            }

            queue.add(nums[i]);

            if (p >= 0) {
                result[p] = queue.peekFirst();
            }
        }

        return result;
    }
}
