package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    15. 3Sum
    Time Complexity: O(n^2)
    Space: O(N)
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right =nums.length-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            else {
                while(left<right){
                    int threeSum =nums[i]+nums[left] + nums[right];
                    if(threeSum >0){
                        right--;
                    }
                    else if(threeSum <0){
                        left++;
                    }
                    else {
                        res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        while (left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
