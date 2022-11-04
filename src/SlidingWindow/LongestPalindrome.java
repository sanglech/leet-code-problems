package SlidingWindow;

import java.util.HashMap;

/*
    409. Longest Palindrome
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> stringMap = new HashMap<>();
        if(s.length()==1){
            return 1;
        }

        for (Character c: s.toCharArray()){
            if(!stringMap.containsKey(c)){
                stringMap.put(c,1);
            }
            else {
                stringMap.put(c,stringMap.get(c)+1);
            }
        }

        int oddMax = 0;
        for (Integer val: stringMap.values()){
            if(val%2!=0){
                oddMax++;
            }

        }

        if(oddMax>=1){
            return (s.length()-oddMax) +1;
        }

        return s.length();
    }
}
