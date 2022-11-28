class Solution:
    def climbStairs(self, n: int) -> int:
        if n<=2:
            return n
        val_1= 1
        val_2 =2
        
        i =3
        while i<=n:
            newVal = val_1 + val_2
            val_1 = val_2
            val_2 = newVal
            i = i+1
        return val_2