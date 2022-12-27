from typing import List

# Greedy Algorithim Solution
class Solution:
    def maximumBags(self, capacity: List[int], rocks: List[int], additionalRocks: int) -> int:
        bagsCapacity =[]
        res =0

        for cap,rock in zip(capacity,rocks):
            bagsCapacity.append(cap-rock)
        
        bagsCapacity.sort()

        for bagCap in bagsCapacity:
            if additionalRocks <=0:
                break
            if additionalRocks >= bagCap:
                res+=1
            additionalRocks-=bagCap
        return res
