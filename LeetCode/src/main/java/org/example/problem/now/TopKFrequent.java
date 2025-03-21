package org.example.problem.now;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[k];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() == k) {
                if (priorityQueue.peek()[1] < entry.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            result[i] = priorityQueue.poll()[0];
        }

        return result;
    }
}
