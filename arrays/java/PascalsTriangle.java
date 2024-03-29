package arrays.java;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle {
    public List<List
            <Integer>> generate(int numRows) {
        List<List<Integer>> allRows = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i < numRows; i++){
            row.add(0,1);
            for(int j = 1; j < row.size()-1;j++){
                row.set(j, row.get(j) + row.get(j+1));
                // System.out.println(row);
            }
            allRows.add(new ArrayList<>(row));
        }
        return allRows;
    }
}