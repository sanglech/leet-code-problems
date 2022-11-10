package DynamicProgramming;

import java.util.HashSet;

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

    public boolean canPartitionHashSet(int[] nums) {
        if(nums.length<=1) return false;
        int capacity =0;

        for (int num : nums){
            capacity+=num;
        }

        if(capacity%2!=0){
            return false;
        }

        capacity/=2;

        HashSet<Integer> solution = new HashSet<>();

        solution.add(0);
        for(int num : nums){
            solution.add(num);
            HashSet<Integer> temp = solution;
            for(int i :solution){
                if(num+i == capacity){
                    return true;
                }
                temp.add(num+i);
            }
        }

        return solution.contains(capacity);
    }

    public boolean canPartitionAlternate(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0) dp[i][j] = false;
                    else dp[i][j] = true;
                } else if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
