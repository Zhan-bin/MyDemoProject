package org.example.problem.now;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (j < s.length()) {
            while (i < j && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            max = Math.max(max, j - i + 1);
            set.add(s.charAt(j++));
        }

        return max;
    }
}
