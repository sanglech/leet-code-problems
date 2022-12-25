from bisect import bisect_right
from typing import List


class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        preSum = [0]
        for n in nums:
            preSum.append(preSum[-1]+n)
        res = []
        for q in queries:
            indx = bisect_right(preSum,q) #alternative?
            res.append(indx-1)
        return res
