package ArraysWithHashing.Easy;

import java.util.HashMap;
/*
    290. Word Pattern
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        int pLen = pattern.length();
        int sLen = s.length();
        String [] strs = s.split(" ");
        if (Math.min(pLen,sLen)==0 || strs.length!=pLen) return false;
        HashMap<Character, String> wordMap = new HashMap<>();

        for ( int i =0; i <pLen;i++){
            String thing = wordMap.get(pattern.charAt(i));
            if (thing==null){
                if(!wordMap.containsValue(strs[i])){
                    wordMap.put(pattern.charAt(i),strs[i]);
                }
                else {
                    return false;
                }
            } else {
                if(!strs[i].equals(wordMap.get(pattern.charAt(i)))){
                    return false;
                }
            }
        }
        return true;
    }
}
