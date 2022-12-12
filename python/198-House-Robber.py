from typing import List

class Solution:
    def rob(self, nums: List[int]) -> int:
        maxAmount = 0
        if len(nums)== 1:
            return nums[0]
        elif(len(nums))== 2:
            return max(nums[0],nums[1])
        firstHouse = 0
        secondHouse = 0

        for i in range(len(nums)):
            currMax = max(firstHouse+ nums[i],secondHouse)
            firstHouse = secondHouse
            secondHouse = currMax

        return secondHouse
