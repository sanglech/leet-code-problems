package Recursion;
/*
    695. Max Area of Island
 */
public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid.length==0) return maxArea;

        for(int i=0; i< grid.length;i++){
            for(int j =0; j< grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea=Math.max(dfs(grid,i,j),maxArea);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][]grid, int i , int j){
        int count=0;
        if (i < 0 ||j < 0 ||i >= grid.length ||j >= grid[0].length ||grid[i][j] == 0) {
            return 0;
        }
        count++;
        grid[i][j] = 0;
        count+=dfs(grid, i + 1, j);
        count+=dfs(grid, i, j + 1);
        count+=dfs(grid, i - 1, j);
        count+=dfs(grid, i, j - 1);
        return count;
    }
}
