package org.example.problem.now;

public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            maxArea = Math.max(maxArea, calArea(height, i, j));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }

    private int calArea(int[] height, int i, int j) {
        return Math.min(height[i], height[j]) * (j - i);
    }
}
