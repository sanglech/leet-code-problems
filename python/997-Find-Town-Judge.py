from typing import List

class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n==1 and len(trust)==0:
            return 1
        counts = [0]*(n+1)

        for person in trust:
            counts[person[0]]-=1
            counts[person[1]]+=1
        
        for i in range(len(counts)):
            if counts[i]==n-1:
                return i
        return -1
