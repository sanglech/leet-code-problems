from typing import List

class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        normalSum = sum(nums)
        res = nums[0]
        maxSub = nums[0]
        minSub = 0
        for i in range(1,len(nums)):
            maxSub = max(maxSub+nums[i], nums[i])
            minSub = min(minSub+nums[i], nums[i])
            res = max(res, maxSub, normalSum - minSub)
        return res
