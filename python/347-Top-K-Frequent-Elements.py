from collections import defaultdict
from typing import List

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        res = []
        numMap= defaultdict(int)
        freq = [[] for i in range(len(nums)+1)]

        if len(nums)== 0 or k==0:
            return res
        if len(nums)==1:
            return nums
        for num in nums:
            numMap[num]+=1

        for key,val in numMap.items():
            freq[val].append(key)
        
        for val in range(len(freq) - 1, 0, -1):
            for n in freq[val]:
                res.append(n)
                if len(res) == k:
                    return res
