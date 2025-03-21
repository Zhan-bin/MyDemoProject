package org.example.problem.now;

public class MatrixRotate {
    public void rotate(int[][] matrix) {
        diagonalRotate(matrix);
        verticalRotate(matrix);
    }

    private void diagonalRotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {  // j = i + 1 这里易错，不是从0开始
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void verticalRotate(int[][] matrix) {
        for (int j = 0; j < matrix[0].length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                swap(matrix, i, j, i, matrix[0].length - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int k, int l) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[k][l];
        matrix[k][l] = tmp;
    }
}
