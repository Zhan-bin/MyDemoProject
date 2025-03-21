package org.example.problem.history;

public class MaxArea {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
