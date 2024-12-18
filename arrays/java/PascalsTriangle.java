//  118. Pascal's Triangle | Easy
//        Given an integer numRows, return the first numRows of Pascal's triangle.
//
//        In Pascal's triangle, each number is the sum of the two
//        numbers directly above it as shown:
//
//        Example 1:
//
//        Input: numRows = 5
//        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

package arrays.java;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            row.add(0,1);
            for(int j = 1; j < row.size()-1;j++){
                row.set(j, row.get(j) + row.get(j+1));
            }
            System.out.println(row);
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }

    public static void main(String[] args) {
        generate(9);
    }
}