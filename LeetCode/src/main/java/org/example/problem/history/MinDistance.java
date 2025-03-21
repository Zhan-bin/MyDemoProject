package org.example.problem.history;

/**
 *
 */
public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 * len2 == 0) {
            return len1 + len2;
        }

        // 1. 初始化
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // 2. 计算
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int dis1 = dp[i][j - 1] + 1;
                int dis2 = dp[i - 1][j] + 1;
                int dis3 = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);

                dp[i][j] = Math.min(dis1, Math.min(dis2, dis3));
            }
        }

        return dp[len1][len2];
    }
}
