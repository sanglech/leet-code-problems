package DynamicProgramming;

/*
    494. Target Sum
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length ==0 ) return 0;

        return sumHelper(nums, target, nums.length);
    }

    public int sumHelper ( int[] nums, int target, int index){
        if(index== 0){
            if(target==0) return 1;
            else return 0;
        }

        return sumHelper(nums,target-nums[index-1],index-1) +
                sumHelper(nums,target+nums[index-1] ,index-1);
    }

}
