from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []

        def dfs(i: int, curSubset: List[int]):
            if i >= len(nums):
                res.append(curSubset.copy())
                return
            curSubset.append(nums[i])
            dfs(i+1,curSubset)
            
            curSubset.pop()
            dfs(i+1,curSubset)
        dfs(0,[])
        return res
