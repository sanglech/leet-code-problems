package ArraysWithHashing.Easy;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int res =1;
        if(nums.length==1){
            return 1;
        }

        for(int i=1; i< nums.length;i++){
            if(nums[i]==nums[i-1]){
                int j=i;
                while(j<nums.length-1 && nums[j]==nums[i]){
                    j++;
                }
                int temp = nums[j];
                for(int k=i;k<=j;k++){
                    nums[k]=temp;
                }
            }
        }

        for(int i=1; i<nums.length;i++){
            if(nums[i-1]!=nums[i]){
                res++;
            }
            else {
                break;
            }
        }

        return res;
    }
}
