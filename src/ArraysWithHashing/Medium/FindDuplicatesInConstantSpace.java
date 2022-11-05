package ArraysWithHashing.Medium;

import java.util.Arrays;
/*
    287. Find the Duplicate Number
    Space: O(1)
    Time: O(nlogn)
 */
public class FindDuplicatesInConstantSpace {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }

        return -1;
    }
}
