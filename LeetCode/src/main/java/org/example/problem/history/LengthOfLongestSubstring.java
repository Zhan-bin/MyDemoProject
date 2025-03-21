package org.example.problem.history;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            while (set.contains(curr)) {
                set.remove(s.charAt(j++));
            }
            set.add(curr);
            res = Math.max(i - j + 1, res);
        }

        return res;
    }
}
