package Recursion;

import java.util.ArrayList;
import java.util.List;

/*
    39. Combination Sum
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),res,0,0);
        return res;
    }

    public void dfs(int[] canidates, int target, List<Integer> curr,List<List<Integer>> res, int index, int total){
        if(total==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(index >= canidates.length || total > target) return;

        // Choose to include current integer
        curr.add(canidates[index]);
        dfs(canidates,target,curr,res,index,total+canidates[index]);

        //Choose to not include current integer
        curr.remove(curr.get(curr.size() - 1));
        dfs(canidates,target,curr,res,index+1,total);
    }
}
