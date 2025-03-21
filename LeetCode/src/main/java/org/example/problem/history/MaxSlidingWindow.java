package org.example.problem.history;

import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        int i = 1 - k, j = 0;

        while (j < nums.length) {
            if (i > 0 && !queue.isEmpty() && queue.peekFirst() == nums[i - 1]) {
                queue.removeFirst();
            }

            while (!queue.isEmpty() && queue.peekLast() < nums[j]) {
                queue.removeLast();
            }

            queue.addLast(nums[j]);
            if (i >= 0) {
                res[i] = queue.peekFirst();
            }
            i++;
            j++;
        }

        return res;
    }
}
