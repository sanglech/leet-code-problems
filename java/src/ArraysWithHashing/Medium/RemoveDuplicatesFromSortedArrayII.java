package ArraysWithHashing.Medium;

/*
    80. Remove Duplicates from Sorted Array II
    uses slow and fast ptr approach. Since you can have at most 2 same values we set them both to pos 2
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return 2;

        int slow = 2, fast =2;

        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
