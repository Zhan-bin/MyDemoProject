package org.example.problem.now;

import java.util.LinkedList;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peekLast()]) {
                stack.removeLast();
            }
            int last = stack.isEmpty() ? -1 : stack.peekLast();
            result[i] = last >= 0 ? last - i : 0;
            stack.addLast(i);
        }

        return result;
    }
}
