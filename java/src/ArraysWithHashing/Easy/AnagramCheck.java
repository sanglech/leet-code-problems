package ArraysWithHashing.Easy;

import java.util.HashMap;
import java.util.Objects;

public class AnagramCheck {
    // Time Complexity: O(n+m)
    // Space: O(n+m)
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        if(t.length()<s.length()){
            return false;
        }

        for(int i =0; i< s.length();i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.computeIfPresent(s.charAt(i),(k,v)->v+1);
            } else {
                sMap.put(s.charAt(i),1);
            }
        }

        for(int i =0; i< t.length();i++){
            if(tMap.containsKey(t.charAt(i))){
                tMap.computeIfPresent(t.charAt(i),(k,v)->v+1);
            } else {
                tMap.put(t.charAt(i),1);
            }
        }

        for (char k : tMap.keySet()){
            if(!sMap.containsKey(k)){
                return false;
            } else {
                if(!Objects.equals(sMap.get(k), tMap.get(k))){
                    return false;
                }
            }
        }
        return true;
    }
}
