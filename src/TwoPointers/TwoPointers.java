package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    // Time complexity: O(logn)
    // Space complexity: O(1)
    public boolean isPalindrome(String s) {
        final StringBuilder sb = new StringBuilder();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }

        int i =0;
        int j = sb.length()-1;

        while(i<j){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // Time Complexity: O(n)
    // Space: O(1)
    public static int maxArea(int[] height) {
        int maxArea =0;
        if(height.length==2){
            return Math.min(height[0],height[1]);
        }
        int left = 0;
        int right = height.length-1;

        while(left<right){
            int min = Math.min(height[left], height[right]);
            int area = min * (right-left);
            maxArea = Math.max(maxArea,area);

            if(height[left]>height[right]){
                right --;
            }
            else {
                left++;
            }
        }
        return maxArea;
    }

    // Time Complexity: O(n)
    // Space: O(N)
    public static int[] twoSum2(int[] numbers, int target) {
        int l = 0;
        int [] res = new int[2];
        int r = numbers.length -1;

        if(numbers.length==2){
            res[0]=1;
            res[1]=2;
            return res;
        }

        while(l<r){
            if(numbers[l] + numbers[r] > target){
                r--;
            }
            else if(numbers[l]+ numbers[r]<target){
                l++;
            }
            else {
                res[0]= l+1;
                res[1] = r+1;
                break;
            }
        }
        return res;
    }

    // Time Complexity: O(n^2)
    // Space: O(N)
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
