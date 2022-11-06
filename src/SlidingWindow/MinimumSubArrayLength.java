package SlidingWindow;

/*
    209. Minimum Size Subarray Sum
 */
public class MinimumSubArrayLength {
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length ==0) return 0;

        int minLength = Integer.MAX_VALUE;
        int l =0;

        if(nums[l]>=target) return 1;
        int curr = nums[l];
        for (int r =1; r< nums.length;r++){
            curr+=nums[r];
            while(curr >=target){
                minLength = Math.min(minLength,r-l+1);
                curr= curr-nums[l];
                l++;
            }
        }

        if(minLength==Integer.MAX_VALUE) return 0;
        else return minLength;

    }
}
