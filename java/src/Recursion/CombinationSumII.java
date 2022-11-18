package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    40. Combination Sum II
 */
class CombinationSumII {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target);
        return result;
    }

    private void dfs(int[] candidates, int index, List<Integer> currSet, int target)
    {
        if (target == 0)
        {
            List<Integer> currCopy = new ArrayList<>(currSet);
            result.add(currCopy);
            return;
        }

        if (target < 0 || index >= candidates.length) return;

        // two decisions: we can add this current number to our result
        // or we can ignore this number and do a dfs for the next number
        currSet.add(candidates[index]);

        // this first branch will have all the subsets which contain this currently added number
        // we can add this number again so index is not changed
        dfs(candidates, index + 1, currSet, target - candidates[index]);

        // backtrack
        currSet.remove(currSet.size() - 1);

        // skip duplicates
        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1])
        {
            index += 1;
        }

        // second branch will have all the subsets which dont have this current number
        dfs(candidates, index + 1, currSet, target);
    }
}
