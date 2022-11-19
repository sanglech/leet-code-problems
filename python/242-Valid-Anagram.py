class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sMap = {}
        tMap = {}

        if len(t) != len(s):
            return False
        
        for c in t:
            if c in tMap:
                tMap[c]= tMap[c] + 1
            else :
                tMap[c] = 1
        
        for c in s:
            if c in sMap:
                sMap[c] = sMap[c] + 1
            else:
                sMap[c] = 1
        for k in tMap:
            if k not in sMap:
                return False
            elif sMap[k] != tMap[k]:
                return False
        return True