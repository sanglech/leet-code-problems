from collections import deque
from typing import List

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if len(grid)== 0:
            return -1
        ROWS,COLS = len(grid), len(grid[0])
        rottingOranges = deque()
        freshOranges = 0
        levels = 0

        for i in range(ROWS):
            for j in range(COLS):
                if grid[i][j]==1:
                    freshOranges+=1
                elif grid[i][j]==2:
                    rottingOranges.append((i,j))
        
        while freshOranges>0 and rottingOranges:
            for i in range(len(rottingOranges)):
                r,c = rottingOranges.popleft()
                directions = [[0,1],[1,0],[-1,0],[0,-1]]
                for dr,dc in directions:
                    newRow = dr + r
                    newCol = dc + c
                    #Note: instead of checking if out of bounds we check in bounds because 
                    # we only need to do something if its fresh
                    # no need to check out of bonds and if O or 2 check opposite case
                    if (newRow in range(ROWS) 
                        and newCol in range(COLS) 
                        and grid[newRow][newCol]==1):
                        grid[newRow][newCol]=2
                        rottingOranges.append((newRow,newCol))
                        freshOranges-=1
            levels+=1
        if freshOranges > 0:
            return -1
        else:
            return levels
