package SlidingWindow;

import java.util.Arrays;

/*
    567. Permutation in String
    Time Complexity: O(n)
    Space: O(n+m)
 */
public class PermutationInString {
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
