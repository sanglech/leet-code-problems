package ArraysWithHashing.Easy;

public class PivotIndex {
    public static int pivotIndex(int[] nums) {
        int total = 0;
        int currTotal = 0;
        for(int num : nums){
            total+=num;
        }

        for(int i =0; i<nums.length;i++){
            currTotal+=nums[i];
            if(total==currTotal){
                return i;
            }
            else {
                total-=nums[i];
            }
        }

        return -1;
    }
}
