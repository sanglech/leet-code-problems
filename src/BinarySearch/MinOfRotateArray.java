package BinarySearch;
/*
    153. Find Minimum in Rotated Sorted Array
 */
public class MinOfRotateArray {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int res = Integer.MAX_VALUE;
        int l =0, r= nums.length-1;

        while(l<=r){
            int m = l+(r-l)/2;
            res = Math.min(res,nums[m]);
            // Search left side of sorted array.
            if(nums[m] >= nums[r]) {
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return res;
    }
}
