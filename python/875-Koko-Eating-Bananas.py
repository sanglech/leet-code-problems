import math
from typing import List

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        
        res = right

        while left<=right:
            k = (left + right)//2
            timeToEat = 0
            for p in piles:
                timeToEat += math.ceil(p/k)
            if timeToEat <=h:
                res = min(res,k)
                right =k-1
            else:
                left = k +1
        return res
