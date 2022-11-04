package SlidingWindow;

import java.util.HashSet;

/*
    3. Longest Substring Without Repeating Characters
    Time Complexity: O(n)
    Space: O(n)
 */
public class LongestSubstringWithoutRepeat {
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
}
