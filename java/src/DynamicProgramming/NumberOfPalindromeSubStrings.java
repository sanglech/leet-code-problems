package DynamicProgramming;

/*
    647. Palindromic Substrings
 */
public class NumberOfPalindromeSubStrings {
    public int countSubstrings(String s) {
        int palindromeLength = 0;
        int res =0;

        if (s.length()==0) return 0;
        if (s.length()==1) return 1;

        for (int i = 0; i <= s.length(); i++) {
            // odd length
            res+= helper(s, i, i);


            // even length
            res+= helper(s, i, i + 1);
        }
        return res;
    }

    public int helper(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }
}
