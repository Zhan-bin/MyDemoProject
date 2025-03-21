package org.example.problem.history;

public class Trap {
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int len = height.length;
        int max = 0;
        int[] left = new int[len];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, height[i - 1]);
            left[i] = max;
        }

        max = 0;
        int[] right = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            right[i] = max;
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            int water = Math.min(left[i], right[i]) - height[i];
            if (water > 0) {
                res += water;
            }
        }

        return res;
    }
}
