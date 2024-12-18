//    73. Set Matrix Zeroes | Medium
//
//        Given an m x n integer matrix, if an element is 0, set its
//        entire row and column to 0's.
//
//        You must do it in place.
//
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//        Output: [[1,0,1],[0,0,0],[1,0,1]]



package arrays.java;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        // I. Naive Solution
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j]==0){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(rows.contains(i) || columns.contains(j)) matrix[i][j] =0;
            }
        }

        // Better Approach | Space saved
        boolean firstRowHasZero = false;
        boolean firstColhasZero = false;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    if (i == 0) firstRowHasZero = true;
                    if (j == 0) firstColhasZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if(firstRowHasZero){
            for (int i = 0; i < colLen; i++) {
                matrix[0][i] = 0;
            }
        }

        if(firstColhasZero){
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }


    }

    public static void main(String[] args) {

    }
}
