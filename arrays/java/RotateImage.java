package arrays.java;

import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);

        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
//        System.out.println(mat);
    }
}
