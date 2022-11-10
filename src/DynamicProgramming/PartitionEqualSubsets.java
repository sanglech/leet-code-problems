package DynamicProgramming;

/*
    416. Partition Equal Subset Sum
 */
public class PartitionEqualSubsets {
    public boolean canPartition(int[] nums) {
        if(nums.length<=1) return false;
        int capacity =0;

        for (int num : nums){
            capacity+=num;
        }

        if(capacity%2!=0){
            return false;
        }

        capacity/=2;

        boolean[][] dp = new boolean [nums.length+1][capacity+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0)
                    dp[i][j] = false;
                else if(nums[i-1] > j)     // if curr sum value is greater than the current element value then just skip(take previous value)
                    dp[i][j] = dp[i-1][j];
                else if(nums[i-1]==j)  // we got required sum
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][capacity];
    }
}
