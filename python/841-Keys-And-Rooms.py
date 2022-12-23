from collections import deque
from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        n= len(rooms)
        if n<=1:
            return True
        q= deque()
        visit = set()
        q.append(0)
        visit.add(0)

        while q:
            for i in range(len(q)):
                current = q.pop()
                for key in rooms[current]:
                    if not key in visit:
                        q.append(key)
                visit.add(current)
        return len(visit)==n
