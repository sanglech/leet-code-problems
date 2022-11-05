package ArraysWithHashing.Medium;

import java.util.HashSet;

/*
    36. Valid Sudoku
 */
public class IsValidSudoku {
    // Time Complexity: O(n*m)
    //Space: O(n)
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<String>();
        for(int row=0; row < 9; row++){
            for(int col=0; col< 9; col++){
                if(board[row][col] != '.'){
                    //Check whether HashSet contains duplicate elements in row and column
                    if(h1.contains("row" + row + board[row][col]) || h1.contains("col" + col + board[row][col]) ){
                        return false;
                    }
                    h1.add("row" + row + board[row][col]);
                    h1.add("col" + col + board[row][col]);

                    //Check whether Box contains duplicate elements in it
                    if(h1.contains("box"+ (row/3) + (col/3) + board[row][col])){
                        return false;
                    }
                    h1.add("box"+ (row/3) + (col/3) + board[row][col]);
                }
            }
        }
        return true;
    }
}
