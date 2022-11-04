package ArraysWithHashing.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    // Time Complexity: O(mlogn)
    // Space: O(n)
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String s: strs){
            char [] temp = s.toCharArray();
            Arrays.sort(temp);

            if(map.containsKey(Arrays.toString(temp))) {
                map.get(Arrays.toString(temp)).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(Arrays.toString(temp),newList);
            }
        }

        for(String key: map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}
