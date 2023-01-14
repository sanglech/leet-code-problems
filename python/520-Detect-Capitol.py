class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        if len(word)==0:
            return False
    
        if(word.isupper() or word.islower()):
            return True
        
        i=0
        for c in word:
            if c.isupper() and i!=0:
                return False
            i+=1
        return True
