package BinarySearch;

/*
    33. Search in Rotated Sorted Array
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if (nums.length ==0) return -1;
        if(nums.length==1) return nums[0]==target ? 0:-1;
        int l =0, r= nums.length-1;
        while(l<=r){
            int m = l + (r - l) / 2;
            if(nums[m]==target) return m;
            // Search left side of sorted array.
            if(nums[m] >= nums[l]){
                if(target> nums[m] || target < nums[l] ) l=m+1;
                else r = m-1;
            } else { //Search right side of sorted array.
                if(target<nums[m] || target> nums[r]) r =m-1;
                else l=m+1;
            }
        }
        return -1;
    }
}
