package DynamicProgramming;

/*
    790. Domino and Tromino Tiling
    Mathematical explanation of DP/Recursion
    https://cs.stackexchange.com/questions/66658/domino-and-tromino-combined-tiling
    
 */
public class DominoTrominoTiling {
    public int numTilings(int n) {
        int modVal =1000000007;
        if (n==1) return 1;
        if (n==2) return 2;

        long dp[] = new long[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i =3;i<=n;i++){
            dp[i] = (2*dp[i-1]+dp[i-3])%modVal;
        }
        return (int) dp[n];
    }
}
