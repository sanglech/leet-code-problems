from typing import List
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        remainderMap={}
        for i,num in enumerate(nums):
            diff=target-num
            if diff in remainderMap:
                return [remainderMap[diff],i]
            remainderMap[num]=i