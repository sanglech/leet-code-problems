from typing import List

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) <=1:
            return True
        goal = len(nums)-1 #position need to get to

        #iterate through the list backwards
        for i in range(len(nums)-1,-1,-1):
            if i + nums[i] >=goal:
                goal = i # update goal to current position if we can reach goal from here
        return goal==0
