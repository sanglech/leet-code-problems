package ArraysWithHashing.Medium;

import java.util.HashMap;

public class IsomorphicCheck {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap = new HashMap<>();
        HashMap<Character,Character> tMap = new HashMap<>();

        if(s.length()!=t.length()){
            return false;
        }

        for (int i =0; i< s.length();i++){
            if(!sMap.containsKey(s.charAt(i))) sMap.put(s.charAt(i),t.charAt(i));
            if(!tMap.containsKey(t.charAt(i))) tMap.put(t.charAt(i),s.charAt(i));
        }
        for(int i=0;i<t.length();i++){
            if(tMap.get(t.charAt(i)) != s.charAt(i) || sMap.get(s.charAt(i)) != t.charAt(i))
            {return false;}
        }

        return true;
    }
}
