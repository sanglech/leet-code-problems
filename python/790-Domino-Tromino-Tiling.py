class Solution:
    def numTilings(self, n: int) -> int:
        modVal =1000000007
        if n <=2:
            return n
        dp = [0] * (n+1)
        for i in range(n+1):
            if i <=1:
                dp[i]=1
            elif i==2:
                dp[i]=2
            else:
                dp[i]=((2*dp[i-1] + dp[i-3])%modVal)
        return dp[n]
