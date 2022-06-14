package SlidingWindow;

import java.util.*;

public class SlidingWindow {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }

        int buyDay= 0;
        int maxProfit = Math.max(0,prices[1]-prices[buyDay]);

        for (int sellDay =1; sellDay< prices.length; sellDay++) {
            int currPrice = prices[sellDay];
            if(currPrice-prices[buyDay]<0){
                buyDay=sellDay;
            } else {
                maxProfit = Math.max(maxProfit,currPrice-prices[buyDay]);
            }
        }

        return maxProfit;
    }


    public static int lengthOfLongestSubstring(String s) {
        int max =0;
        int l =0;
        HashSet<Character> visited = new HashSet<>();

        if(s.length()==0){
            return 0;
        }
        for(int r=0;r<s.length();r++){
            while(visited.contains(s.charAt(r))){
                visited.remove(s.charAt(l));
                l++;
            }
            max = Math.max(r-l+1, max);
            visited.add(s.charAt(r));
        }

        return max;
    }

    public static int[] twoSum(int[] numbers, int target) {
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

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> characterCount = new HashMap<>();
        int result = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char end = s.charAt(windowEnd);
            characterCount.put(end, (characterCount.getOrDefault(end, 0) + 1));

            while ((windowEnd - windowStart + 1) - Collections.max(characterCount.values()) > k) {
                char startChar = s.charAt(windowStart);
                characterCount.put(startChar, characterCount.get(startChar) - 1);
                windowStart = windowStart + 1;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        return result;
    }


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

    public static boolean checkInclusion(String s1, String s2) {

        if(s2.length()<s1.length()) return false;
        int right = s1.length();

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);

        for(int i=0; i<=s2.length()-right;i++){
            char[] temp = (s2.substring(i, i+right)).toCharArray();
            Arrays.sort(temp);
            if(Arrays.equals(temp, s1Arr)){
                return true;
            }
        }
        return false;
    }

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
}
