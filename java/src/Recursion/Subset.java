package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    78. Subsets
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==0) return res;
        List<Integer> subset = new ArrayList<>();
        subsetCreator(0,nums,subset,res);

        return res;
    }

    public void subsetCreator(int i, int[]nums,List<Integer> curSet, List<List<Integer>> res){
        if(i>= nums.length){
            // Create a copy of the current set and add it to the final response
            res.add(new ArrayList<>(curSet));
            return;
        }
        // Decision to add num at i to current set
        curSet.add(nums[i]);
        subsetCreator(i+1,nums,curSet,res);
        curSet.remove(curSet.size()-1);

        // Decision to not add num at i to current set
        subsetCreator(i+1,nums,curSet,res);
    }
}
