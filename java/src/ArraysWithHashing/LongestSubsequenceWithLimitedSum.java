package ArraysWithHashing;

import java.util.Arrays;

/*
    2389. Longest Subsequence With Limited Sum
 */
public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        int[] prefix = new int[nums.length];
        if (nums.length==0)  return res;

        Arrays.sort(nums);
        int total=nums[0];
        prefix[0]=total;

        for (int i=1;i<prefix.length;i++){
            total+=nums[i];
            prefix[i]=total;
        }

        for(int i=0; i<queries.length; i++) {
            int idx = -1;
            for(int j=0; j<nums.length; j++) {
                if(prefix[j] <= queries[i]) {
                    idx = j;
                } else {
                    break;
                }
            }
            res[i] = idx+1;
        }
        return res;
    }
}
