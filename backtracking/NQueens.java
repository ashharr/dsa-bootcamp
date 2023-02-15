package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        NQueens(board,n, ans, 0);
        return ans;
    }
    public static void NQueens(char[][] board, int n, List<List<String>> ans, int col){
        if(col == n){
            List<String> res = resultBuilder(board);
            ans.add(res);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (isValid(n, board, row, col)) {
                board[row][col] = 'Q';
                NQueens(board, n, ans, col + 1);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isValid(int n, char[][] board, int row, int col){
        // Left Row
        for (int i = col; i >= 0; i--) {
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for (int i = row+1, j = col-1; i<n && j>=0; i++, j--) {
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    public static List<String> resultBuilder(char[][] board){
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < (board[i].length - 1); i++) {
            temp.add(new String(board[i]));
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println((solveNQueens(5)));
    }
}
