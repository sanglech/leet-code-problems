package DynamicProgramming;

public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0) return 0;
        if(obstacleGrid.length==1 && obstacleGrid[0].length==1 && obstacleGrid[0][0]==0) return 1;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if(obstacleGrid[rows-1][cols-1]==1) return 0;
        int [][] grid = new int [rows][cols];
        boolean obstacleFound = false;

        for(int r = 0; r < rows; r++){
            if(obstacleGrid[r][0] == 1) obstacleFound = true;
            if(!obstacleFound && obstacleGrid[r][0] ==0) grid[r][0]= 1;
            else grid[r][0]=0;
        }
        obstacleFound = false;
        for(int c =0; c< cols;c++){
            if(obstacleGrid[0][c] == 1) obstacleFound = true;
            if(!obstacleFound && obstacleGrid[0][c] ==0) grid[0][c]= 1;
            else grid[0][c]=0;
        }

        for(int i =1; i< rows;i++){
            for (int j= 1;j< cols;j++){
                if(obstacleGrid[i][j]==0){
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }

        return grid[rows-1][cols-1];
    }
}
