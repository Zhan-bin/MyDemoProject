package org.example.problem.now;

public class Trap {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }

        max = 0;
        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            result += getTrap(i, height, left, right);
        }

        return result;
    }

    private int getTrap(int i, int[] height, int[] left, int[] right) {
        int h = Math.min(left[i - 1], right[i + 1]);
        return Math.max(h - height[i], 0);
    }
}
