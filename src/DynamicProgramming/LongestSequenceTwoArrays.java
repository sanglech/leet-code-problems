package DynamicProgramming;

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
}
