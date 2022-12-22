from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list) # use default dict to avoid edge cases
        for s in strs:
            count =[0]*26 # a...z
            for c in s:
                # ascii value of c - ascii value of a then insert that pos in array
                count[ord(c)- ord('a')]+=1 
            res[tuple(count)].append(s)
        return res.values()
