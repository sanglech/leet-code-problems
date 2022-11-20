class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x< 0:
            return False
        strX= str(x)
        l=0
        r=len(strX)-1

        while(l<r):
            if strX[l] != strX[r]:
                return False
            l= l+1
            r = r-1
        return True