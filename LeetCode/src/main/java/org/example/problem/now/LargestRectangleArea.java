package org.example.problem.now;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int i = 0, j = heights.length - 1, ans = 0;
        while (i <= j) {
            if (heights[i] < heights[j]) {
                ans = Math.max(ans, (j - i + 1) * heights[i]);
                i++;
            } else {
                ans = Math.max(ans, (j - i + 1) * heights[j]);
                j--;
            }
        }

        return ans;
    }
}
