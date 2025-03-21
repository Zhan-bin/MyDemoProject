package org.example.problem.now;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
        int upLimit = 0, downLimit = matrix.length - 1, leftLimit = 0, rightLimit = matrix[0].length - 1;
        int i = 0, j = 0, size = matrix.length * matrix[0].length;
        int status = RIGHT;
        List<Integer> result = new ArrayList<>();
        while (size > 0) {
            switch (status) {
                case RIGHT:
                    for (; j <= rightLimit; j++, size--) {
                        result.add(matrix[i][j]);
                    }
                    i++;
                    j--;
                    upLimit++;
                    status = DOWN;
                    break;
                case DOWN:
                    for (; i <= downLimit; i++, size--) {
                        result.add(matrix[i][j]);
                    }
                    i--;
                    j--;
                    rightLimit--;
                    status = LEFT;
                    break;
                case LEFT:
                    for (; j >= leftLimit; j--, size--) {
                        result.add(matrix[i][j]);
                    }
                    j++;
                    i--;
                    downLimit--;
                    status = UP;
                    break;
                case UP:
                    for (; i >= upLimit; i--, size--) {
                        result.add(matrix[i][j]);
                    }
                    i++;
                    j++;
                    leftLimit++;
                    status = RIGHT;
                    break;
            }
        }
        return result;
    }
}
