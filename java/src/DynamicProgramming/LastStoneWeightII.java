package DynamicProgramming;

/*
    1049. Last Stone Weight II

    This question eaquals to partition an array into 2 subsets whose difference is minimal
    (1) S1 + S2  = S
    (2) S1 - S2 = diff

    ==> -> diff = S - 2 * S2  ==> minimize diff equals to  maximize S2

    Now we should find the maximum of S2 , range from 0 to S / 2, using dp can solve this

    dp[i][j]   = {true if some subset from 1st to j'th has a sum equal to sum i, false otherwise}

    same as 494. Target Sum
 */
public class LastStoneWeightII {
    public static int lastStoneWeightII(int[] stones) {
        int S = 0, S2 = 0;
        for (int s : stones) S += s;
        boolean[][] dp = new boolean[S+1][stones.length+1];
        for (int i = 0; i <= stones.length; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= stones.length; i++) {
            for (int s = 1; s <= S / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(S2, s);
                }
            }
        }
        return S - 2 * S2;
    }
}
