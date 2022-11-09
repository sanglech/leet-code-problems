package DynamicProgramming;

/*
    5. Longest Palindromic Substring
 */
public class LongestPalindromeSubString {
    public static String longestPalindromeSubString(String s) {
        if(s.length()==0) return "";
        if(s.length()==1) return s;

        String res = String.valueOf(s.charAt(0));
        String curr ="";
        for (int i =0; i< s.length();i++){

            curr= longesPalindromeHelper(s,i,i);
            if(curr.length()> res.length()){
                res=curr;
            }

            curr =longesPalindromeHelper(s,i,i+1);
            if(curr.length()> res.length()){
                res=curr;
            }
        }
        return res;
    }

    public static String longesPalindromeHelper(String s, int l, int r) {
        int resLen = 0;
        String res ="";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (r - l + 1 > resLen) {
                res= s.substring(l,r+1);
                resLen= res.length();
            }
            l--;
            r++;
        }
        return res;
    }

}
