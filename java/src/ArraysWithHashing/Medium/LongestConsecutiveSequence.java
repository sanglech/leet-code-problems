package ArraysWithHashing.Medium;

import java.util.HashSet;

/*
    128. Longest Consecutive Sequence
    Time Complexity: O(n)
    Space: O(n)
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        int longest = 0;
        for(int i: nums){
            numSet.add(i);
        }

        for (int num: nums){
            int curr =1;
            if(!numSet.contains(num-1)){
                int i=1;
                while(numSet.contains(num+i)){
                    curr++;
                    i++;
                }

            }
            longest = Math.max(longest,curr);
        }

        return longest;
    }
}
