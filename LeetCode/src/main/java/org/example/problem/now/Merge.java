package org.example.problem.now;

import java.util.Arrays;
import java.util.Comparator;

public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }

        int INDEX_START = 0;
        int INDEX_END = 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[INDEX_START] - o2[INDEX_START];
            }
        });

        int curr = 0;
        for (int next = 1; next < intervals.length; next++) {
            if (intervals[curr][INDEX_END] >= intervals[next][INDEX_START]) {
                intervals[curr][INDEX_END] = Math.max(intervals[curr][INDEX_END], intervals[next][INDEX_END]);
            } else {
                intervals[++curr] = intervals[next];
            }
        }

        return Arrays.copyOfRange(intervals, 0, curr + 1);
    }
}
