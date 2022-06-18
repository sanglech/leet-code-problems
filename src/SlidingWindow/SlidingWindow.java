package SlidingWindow;

import java.util.*;

public class SlidingWindow {
    // Time Complexity: O(n)
    // Space: O(1)
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


    // Time Complexity: O(n)
    // Space: O(n)
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


    // Time Complexity: O(n)
    // Space: O(N)
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


    // Time Complexity: O(n)
    // Space: O(n+m)
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

}
