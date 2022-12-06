from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0

        if len(grid)<=0:
            return islands
        
        # Note: Can create a hashset and add coord to set and check if coord is in set if not allowed to
        # update the grid.
        def dfs(row:int, col:int):
            if (row < 0 or col < 0 or row >= len(grid) or col >= len(grid[0]) or grid[row][col] == '0'):
                return
            grid[row][col] = '0'
            directions = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            for dr, dc in directions:
                dfs(row + dr, col + dc)
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=="1":
                    dfs(i,j)
                    islands +=1

        return islands
