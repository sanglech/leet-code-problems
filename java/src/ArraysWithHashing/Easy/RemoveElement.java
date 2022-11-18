package ArraysWithHashing.Easy;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                int j= i;
                while(nums[j]==val && j< nums.length-1){
                    j++;
                }
                nums[i]=nums[j];
                nums[j]=val;
            }
        }

        for (int num : nums) {
            if (num != val) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
