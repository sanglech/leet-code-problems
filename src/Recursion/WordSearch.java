package Recursion;

/*
    79. Word Search
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length==0) return false;
        if(word.length() > (board.length)* board[0].length || word.length()==0) return false;

        for( int i =0; i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word,int k){
        if (k>=word.length()) return true; // we found a path that is equal to the word length.
        if (i < 0
                ||j < 0
                ||i >= board.length
                ||j >= board[0].length
                ||board[i][j] == 0
                || board[i][j] != word.charAt(k)) {
            return false;
        }
        boolean exist=false;

        if(board[i][j]==word.charAt(k)){
            board[i][j]+=100; // Marked character as visited
            exist = dfs(board,i+1,j,word,k+1)||
                    dfs(board,i,j+1,word,k+1) ||
                    dfs(board,i-1,j,word,k+1) ||
                    dfs(board,i,j-1,word,k+1);
            board[i][j]-=100; // unmark character as visited
        }
        return exist;
    }
}
