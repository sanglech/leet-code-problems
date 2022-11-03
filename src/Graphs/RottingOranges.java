package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0) return -1;

        int rows= grid.length;
        int cols = grid[0].length;

        int result =0;
        int freshOranges =0;
        Deque<int[]> queue = new ArrayDeque<>();

        for(int i=0;i< grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshOranges++;
                }
                else if(grid[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty() && freshOranges!=0){
            int queueLength = queue.size();
            result++;
            for (int i = 0; i < queueLength; i++) {
                int[] rotten = queue.poll();
                int r = rotten[0], c = rotten[1];

                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for (int j = 0; j < 4; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == rows || newC == cols
                            || grid[newR][newC] != 1) {
                        continue;
                    }

                    freshOranges--;
                    queue.add(neighbors[j]);
                    grid[newR][newC] = 2;
                }
            }
        }

        if(freshOranges>0){
            return -1;
        }
        return result;
    }
}
