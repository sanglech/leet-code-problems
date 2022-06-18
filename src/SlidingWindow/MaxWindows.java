package SlidingWindow;

import java.util.ArrayList;
import java.util.List;
/*
    Given an array of numbers and a window size.
   Return the max value for every window in the number array. (sliding window)
 */

// Time Complexity: O(n)
// Space: O(n)
public class MaxWindows {
    public static Integer [] maxWindows (int[] vals, int window){
        List<Integer> results = new ArrayList<>();
        int max =0;
        for (int i =0; i<Math.min(window,vals.length);i++){
            max = Math.max(max,vals[i]);
        }
        results.add(max);
        if(vals.length>window){
            for(int i = window-1;i<vals.length-1;i++){
                max=Math.max(max,vals[i+1]);
                results.add(max);
            }
        }
        return results.toArray(Integer[]::new);
    }
}
