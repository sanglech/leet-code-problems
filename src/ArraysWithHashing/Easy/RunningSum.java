package ArraysWithHashing.Easy;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        int [] res = new int [nums.length];
        int currRes= 0;

        for (int i =0;i<nums.length;i++){
            currRes+=nums[i];
            res[i]=currRes;
        }
        return res;
    }

}
