package ArraysWithHashing.Easy;

/*
    35. Search Insert Position
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) return nums.length;
        if (target < nums[0]) return 0;
        int res =0;

        int l=0, r=nums.length;
        int mid=0;
        while(l<r){
            mid = l+ (r-l)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]> target){
                r = mid-1;
            }
            else {
                l= mid+1;
            }
        }
        res =mid;
        return res;
    }
}
