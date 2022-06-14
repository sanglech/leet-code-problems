package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LongestSequenceTwoArrays {

    public static int FindMaxLength(int [] arr1, int []arr2){
        int len = arr1.length;
        int len2 = arr2.length;

        int [][]dp = new int[len+1][len2+1];
        int max =0;

        for (int i = 0; i <= len; i++)
            for (int j = 0; j <= len2; j++)
                dp[i][j] = 0;

        // Updating the dp[][] table
        // in Bottom Up approach
        for (int i = len - 1; i >= 0; i--)
        {
            for (int j = len2 - 1; j >= 0; j--)
            {
                // If A[i] is equal to B[i]
                // then dp[j][i] = dp[j + 1][i + 1] + 1
                if (arr1[i] == arr2[j])
                    dp[j][i] = dp[j + 1][i + 1] + 1;
            }
        }

        // Find maximum of all the values
        // in dp[][] array to get the
        // maximum length
        for (int i = 0; i < len; i++)
        {
            for (int j = 0; j < len2; j++)
            {
                // Update the length
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static List<String> longestCommonSubarray(String[] s1, String[] s2) {
        List<String> result = new ArrayList<>();
        int n = s1.length, m = s2.length, max = 0, maxi = 0;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j =1; j <= m; j++ ) {
                if(Objects.equals(s1[i - 1], s2[j - 1])) {
                    dp[i][j] = dp[i-1][j -1] + 1;
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                        maxi = i;
                    }
                }
            }
        }

        for(int k = maxi - max; k < maxi; k++) {
            result.add(s1[k]);
        }
        return result;
    }
}
