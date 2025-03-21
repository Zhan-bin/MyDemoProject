package org.example.problem.now;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    final String[] charArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        dfs(digits, 0, result, new StringBuilder());

        return result;
    }

    private void dfs(String digits, int index, List<String> result, StringBuilder stringBuilder) {
        if (index >= digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }

        int digit = Integer.valueOf(String.valueOf(digits.charAt(index)));
        String digChar = charArray[digit];
        for (char c : digChar.toCharArray()) {
            stringBuilder.append(c);
            dfs(digits, index + 1, result, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
