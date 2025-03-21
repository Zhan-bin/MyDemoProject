package org.example.problem.now;

public class MinWindow {
    public String minWindow(String s, String t) {
        char[] sChar = s.toCharArray();
        int[] sCnt = new int[128], tCnt = new int[128];

        for (int i = 0; i < t.length(); i++) {
            tCnt[t.charAt(i)]++;
        }

        int l = 0, ansL = 0, ansR = sChar.length - 1;
        for (int r = 0; r < sChar.length; r++) {
            sCnt[sChar[r]]++;
            while (l <= r && isConvert(sCnt, tCnt)) { // 易错点，使用<=而不是<
                if (r - l < ansR - ansL) {
                    ansL = l;
                    ansR = r;
                }

                sCnt[sChar[l++]]--;
            }
        }

        return s.substring(ansL, ansR + 1);
    }

    private boolean isConvert(int[] sCnt, int[] tCnt) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (sCnt[i] < tCnt[i]) {
                return false;
            }
        }

        return true;
    }
}