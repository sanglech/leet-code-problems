package ArraysWithHashing.Medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    // Time Complexity: O(n)
    // Space: O(n)
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder result = new StringBuilder();
        for (String s: strs){
            result.append(s.length()).append("#").append(s);
        }

        return result.toString();
    }

    public List<String> decode(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        int i =0;

        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(String.valueOf(str.charAt(j-1)));

            String temp = str.substring(j+1,j+length+1);

            result.add(temp);
            i=j+1+length;
        }

        return result;
    }
}
