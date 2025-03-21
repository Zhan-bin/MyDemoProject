package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            frequentMap.put(num, frequentMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeapQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
            if (!minHeapQueue.isEmpty() && minHeapQueue.size() == k) {
                if (minHeapQueue.peek()[1] < entry.getValue()) {
                    minHeapQueue.poll();
                    minHeapQueue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            } else {
                minHeapQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k && !minHeapQueue.isEmpty(); i++) {
            result[i] = minHeapQueue.poll()[0];
        }

        return result;
    }
}
