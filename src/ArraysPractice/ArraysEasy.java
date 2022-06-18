package ArraysPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ArraysEasy {
    // Time Complexity: O(n)
    // Space: O(1)
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i+1< nums.length; i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    // Time Complexity: O(n+m)
    // Space: O(n+m)
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        if(t.length()<s.length()){
            return false;
        }

        for(int i =0; i< s.length();i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.computeIfPresent(s.charAt(i),(k,v)->v+1);
            } else {
                sMap.put(s.charAt(i),1);
            }
        }

        for(int i =0; i< t.length();i++){
            if(tMap.containsKey(t.charAt(i))){
                tMap.computeIfPresent(t.charAt(i),(k,v)->v+1);
            } else {
                tMap.put(t.charAt(i),1);
            }
        }

        for (char k : tMap.keySet()){
            if(!sMap.containsKey(k)){
                return false;
            } else {
                if(!Objects.equals(sMap.get(k), tMap.get(k))){
                    return false;
                }
            }
        }
        return true;
    }

    // Time Complexity: O(n)
    // Space: O(n)
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int [] arr = new int[2];
        if (nums[0]+nums[1]==target){
            arr[1]=1;
            return arr;
        }
        for(int i =0; i< nums.length;i++){
            int remainder = target - nums[i];
            int finalI = i;
            numMap.forEach((key, value) -> {
                if(value==remainder){
                    arr[0]= finalI;
                    arr[1]=key;
                }
            });
            numMap.put(i,nums[i]);
        }
        return arr;
    }

}
