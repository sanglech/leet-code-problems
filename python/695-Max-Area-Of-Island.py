from typing import List

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if len(grid) == 0:
            return 0
        area = 0
        maxArea = 0

        def dfs(row:int, col:int):
            currentArea =0
            if row <0 or col < 0 or row >= len(grid) or col >= len(grid[0]) or grid[row][col]==0:
                return 0
            currentArea+=1
            grid[row][col] = 0
            directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]

            for dr, dc in directions:
                currentArea += dfs(row+dr,col+dc)
            return currentArea

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    area = dfs(i,j)
                    maxArea = max(area,maxArea)
        return maxArea
