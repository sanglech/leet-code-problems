from typing import List

class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        if len(costs)==0 or coins==0:
            return 0
        res = 0
        costs.sort()

        for iceCost in costs:
            if coins-iceCost >=0:
                res+=1
                coins-=iceCost
            else:
                break
        return res
