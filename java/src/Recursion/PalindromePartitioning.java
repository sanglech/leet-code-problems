package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    131. Palindrome Partitioning
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        backtrack(res,new ArrayList<String>(),s,0);

        return res;
    }

    public void backtrack (List<List<String>> res, List<String> cur, String s, int index){

        if(index>=s.length()) {
            res.add(new ArrayList<>(cur));
        }

        for( int j =index;j<s.length();j++){
            if(checkPaindrome(s,index,j)){
                cur.add(s.substring(index,j+1));
                backtrack(res,cur,s,j+1);
                cur.remove(cur.size()-1);
            }
        }

    }

    public boolean checkPaindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
