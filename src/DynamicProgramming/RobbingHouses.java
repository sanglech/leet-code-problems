package DynamicProgramming;

public class RobbingHouses {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        int maxRob1 = 0;
        int maxRob2 =0;

        for(int i : nums){
            int temp = Math.max(i+maxRob1,maxRob2);
            maxRob1 = maxRob2;
            maxRob2 = temp;
        }
        return maxRob2;
    }
}
