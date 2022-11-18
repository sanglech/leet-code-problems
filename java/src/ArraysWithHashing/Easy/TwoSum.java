package ArraysWithHashing.Easy;

import java.util.HashMap;
/*
1. Two Sum
    Problem:
    Given a target value and an array of values.
    Return the two sum of two numbers in the array that add to the target.
    Time Complexity: O(n)
    Space: O(N)
 */

public class TwoSum {
    public static int[] twoSum (int []vals,int target){
        int[] res = new int[2];

        if(vals.length<2){
            return res;
        }

        if(vals.length==2){
            res[1]=1;
            return res;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i=0;i<vals.length;i++){
            int remainder = target-vals[i];
            map.put(i,vals[i]);

            for(Integer k: map.keySet()){
                if(map.get(k)==remainder && k!=i){
                    res[0]= k;
                    res[1]=i;
                    return res;
                }
            }
        }
        return res;
    }
}
