package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/*
    438. Find All Anagrams in a String
 */
public class findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length()> s.length()) return result;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character,Integer> sMap = new HashMap<>();

        for(Character c: p.toCharArray()){
            pMap.put(c,pMap.getOrDefault(c,0)+1);
        }

        int left =0;
        for(int right =0;right<s.length();right++){
            sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0)+1);

            if((right-left)+1 == p.length()){
                boolean isSame = true;
                for(Character c: pMap.keySet()){
                    if(!sMap.containsKey(c)|| !Objects.equals(sMap.get(c), pMap.get(c))){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    result.add(left);
                }

                sMap.put(s.charAt(left),sMap.get(s.charAt(left))-1);
                left++;
            }
        }
        return result;
    }
}
