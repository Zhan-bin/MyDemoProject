package org.example.problem.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    private static boolean[][] f;
    private static List<String> ans;
    private static int sLen;

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }

        sLen = s.length();
        f = new boolean[sLen][sLen];
        for (int i = 0; i < sLen; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = i + 1; j < sLen; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1]);
            }
        }

        ans = new ArrayList<>();
        dfs(s, 0, result);
        return result;
    }

    private void dfs(String s, int index, List<List<String>> result) {
        if (index == sLen) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < sLen; i++) {
            if (f[index][i]) {
                ans.add(s.substring(index, i + 1));
                dfs(s, i + 1, result);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
