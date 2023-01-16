from collections import deque
from typing import List


class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        if n ==0:
            return False
        if n==1 or source == destination:
            return True
        adjList ={}
        q = deque()
        visited = set()

        for n in range(n):
            adjList[n] = []

        for src,dest in edges:
            adjList[src].append(dest)
            adjList[dest].append(src)
        
        q.append(source)
        visited.add(source)

        while q:
            for i in range(len(q)):
                currentVal = q.pop()
                for dest in adjList[currentVal]:
                    if dest == destination:
                        return True
                    if dest not in visited:
                        q.append(dest)
                        visited.add(currentVal)
        return False
