package org.example.problem.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            String cntStr = getCntStr(count);
            List<String> list = map.getOrDefault(cntStr, new ArrayList<>());
            list.add(str);
            map.put(cntStr, list);
        }

        res.addAll(map.values());

        return res;
    }

    private static String getCntStr(int[] count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                stringBuilder.append((char) i + 'a');
                stringBuilder.append(count[i]);
            }
        }

        return stringBuilder.toString();
    }
}
