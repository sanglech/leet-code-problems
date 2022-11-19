class Solution:
    def isPalindrome(self, s: str) -> bool:
       sCombine= "".join([ c if c.isalnum() else "" for c in s ]).lower()
       l =0
       r = len(sCombine)-1

       while(l<r):
           if sCombine[l]!=sCombine[r]:
               return False
           l=l+1
           r=r-1
       return True