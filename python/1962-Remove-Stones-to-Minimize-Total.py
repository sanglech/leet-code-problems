from heapq import heapify, heapreplace
from typing import List


class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        pq = [-p for p in piles] #use negative values to create max heap
        heapify(pq)
        for val in range(k): 
            heapreplace(pq, pq[0]//2)
        return -sum(pq)
