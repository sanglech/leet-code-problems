package ArraysWithHashing.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    944. Delete Columns to Make Sorted
 */
public class MinDeleteCol {
    public static int minDeletionSize(String[] strs) {
        if(strs.length<=1) return 0;
        int count =0;
        HashMap<Integer, List<Character>> charMap = new HashMap<>();

        for (String str: strs){
            for(int i=0;i < str.length();i++){
                charMap.computeIfAbsent(i,k->new ArrayList<>()).add(str.charAt(i));
            }
        }

        for (Integer key: charMap.keySet()){
            List<Character> temp = charMap.get(key);
            for ( int i = 0;i<temp.size()-1;i++){
                if(temp.get(i+1)<temp.get(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
