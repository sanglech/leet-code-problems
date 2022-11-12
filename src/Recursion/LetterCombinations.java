package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    17. Letter Combinations of a Phone Number
 */
public class LetterCombinations {
    Map<Character,String> numMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length()==0) return res;

        backtrack(digits,res,0,"");
        return res;
    }

    public void backtrack(String digits, List<String> res, int index,String cur){
        if(cur.length()==digits.length()){
            res.add(cur);
            return;
        }
        String digitToChar = numMap.get(digits.charAt(index));
        for( Character c: digitToChar.toCharArray()){
            backtrack(digits,res,index+1,cur+c);
        }
    }
}
