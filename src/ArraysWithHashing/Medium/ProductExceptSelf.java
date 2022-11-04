package ArraysWithHashing.Medium;

public class ProductExceptSelf {
    // Time Complexity: O(n)
    // Space: O(n)

    public static int[] productExceptSelf(int[] nums) {
        int preFix =1;
        int postFix =1;

        int [] res = new int[nums.length];

        for(int i =0; i<nums.length;i++){
            res[i] = preFix;
            preFix = nums[i]*preFix;
        }

        for(int j= res.length-1;j>=0;j--){
            res[j]= postFix*res[j];
            postFix = postFix*nums[j];
        }

        return res;
    }
}
