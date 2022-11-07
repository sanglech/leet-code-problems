package ArraysWithHashing.Medium;

/*
    53. Maximum Subarray
    Kadane's Algorithm
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return (nums[0]);
        }
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
