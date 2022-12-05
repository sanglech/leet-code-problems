from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result =[]

        def dfs(currList: List[int], index:int, currentSum: int):
            
            if currentSum == target:
                result.append(currList.copy())
                return

            if index >= len(candidates) or currentSum>target:
                return
            
            #choose to add value
            currList.append(candidates[index])
            dfs(currList,index,currentSum+candidates[index])

            #choose to not add value
            currList.pop()
            dfs(currList,index+1,currentSum)

        dfs([],0,0)
        return result
