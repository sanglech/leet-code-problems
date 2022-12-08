from collections import deque
from typing import List

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        result =1
        if min(ROWS,COLS) <= 0 or grid[0][0]==1 or grid[ROWS-1][COLS-1]==1:
            return -1

        queue = deque()
        visit = set()

        queue.append((0,0))
        visit.add((0,0))

        while queue:
            for i in range(len(queue)):
                r,c = queue.popleft()
                neighbours = [[0,1],[1,0],[1,1],[-1,0],[0,-1],[1,-1],[-1,1],[-1,-1]]
                if r == ROWS-1 and c == COLS-1:
                    return result
                for dr,dc in neighbours:
                    if (min(r+dr, c+dc) <0 or
                        r+dr ==ROWS or 
                        c+dc ==COLS or 
                        grid[r+dr][c+dc] ==1 or 
                        (r + dr, c + dc) in visit):
                        continue
                    queue.append([r+dr,c+dc])
                    visit.add((r+dr,c+dc))
            result +=1
        return -1
