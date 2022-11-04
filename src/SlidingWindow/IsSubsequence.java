package SlidingWindow;

/*
    392. Is Subsequence
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {

        if(s.length()>t.length() || s.length()==0){
            return false;
        }
        int sPos =0;

        for(int i =0 ; i<t.length();i++){
            if(t.charAt(i)==s.charAt(sPos)){
                for(int j=i;j<t.length()&&sPos<s.length();j++){
                    if(t.charAt(j)==s.charAt(sPos)){
                        sPos++;
                    }
                }
                return sPos == s.length();
            }
        }
        return false;
    }
}
