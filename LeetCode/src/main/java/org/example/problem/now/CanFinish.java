package org.example.problem.now;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites.length == 0) {
            return true;
        }

        List<List<Integer>> adjacency = new ArrayList<>();
        int[] indegrees = initIndegreesAndAdj(numCourses, prerequisites, adjacency);
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int c : adjacency.get(course)) {
                indegrees[c]--;

                if (indegrees[c] == 0) {
                    queue.add(indegrees[c]);
                }
            }
        }

        return numCourses == 0;
    }

    private int[] initIndegreesAndAdj(int numCourses, int[][] prerequisites, List<List<Integer>> adjacency) {
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegree[pre[0]]++;
            adjacency.get(pre[1]).add(pre[0]);
        }

        return indegree;
    }
}
