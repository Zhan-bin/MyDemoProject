package org.example.problem.now;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }

        HashMap<String, List<String>> cntStrKeyMap = new HashMap<>();
        for (String str : strs) {
            int[] cntArr = getCntArr(str);
            String cntStr = getCntStr(cntArr);
            List<String> list = cntStrKeyMap.getOrDefault(cntStr, new ArrayList<>());
            list.add(str);
            cntStrKeyMap.put(cntStr, list);
        }

        result.addAll(cntStrKeyMap.values());
        return result;
    }

    private int[] getCntArr(String str) {
        int[] cntArr = new int[26];
        for (char c : str.toCharArray()) {
            cntArr[c - 'a']++;
        }

        return cntArr;
    }

    private String getCntStr(int[] cntArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cntArr.length; i++) {
            if (cntArr[i] <= 0) {
                continue;
            }

            stringBuilder.append((char) (i + 'a'));
            stringBuilder.append(cntArr[i]);
        }

        return stringBuilder.toString();
    }
}
