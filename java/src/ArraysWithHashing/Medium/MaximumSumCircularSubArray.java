package ArraysWithHashing.Medium;
/*
    918. Maximum Sum Circular Subarray
 */
public class MaximumSumCircularSubArray {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];

        int normalMax = maxSubArray(nums);
        if(normalMax < 0) return normalMax;

        int [] reverseSignNums = new int[nums.length];
        int res = 0;
        for(int i=0; i< reverseSignNums.length;i++){
            res+= nums[i];
            reverseSignNums[i] = -nums[i];
        }

        int reverseMax = res + maxSubArray(reverseSignNums);

        return  Math.max(normalMax,reverseMax);
    }

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
