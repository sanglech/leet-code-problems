package SlidingWindow;

import java.util.HashMap;

/*
    409. Longest Palindrome
    Given a string s which consists of lowercase or uppercase letters,
    return the length of the longest palindrome that can be built with those letters.
    Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        HashMap<Character,Integer> stringMap = new HashMap<>();
        if(s.length()==1){
            return 1;
        }

        // build hashmap
        for(Character c: s.toCharArray()){
            stringMap.put(c,stringMap.getOrDefault(c,0)+1);
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
