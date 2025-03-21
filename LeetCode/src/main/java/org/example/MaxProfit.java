package org.example;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int start = 0, end = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[start]) {
                start = i;
            }

            if (prices[i] > prices[end]) {
                end = i;
            }

            if (end < start) {
                end = start;
            }
            maxProfit = Math.max(maxProfit, prices[end] - prices[start]);
        }

        return maxProfit;
    }
}
