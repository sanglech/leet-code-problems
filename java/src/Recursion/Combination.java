package Recursion;

import java.util.ArrayList;
import java.util.List;
/*
    77. Combinations
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n==0) return res;
        List<Integer> subset = new ArrayList<>();
        combinnationCreator(1,n,k,subset,res);

        return res;
    }

    public void combinnationCreator(int i,int n, int k,List<Integer> curSet, List<List<Integer>> res){
        if(curSet.size()==k){
            // Create a copy of the current set and add it to the final response
            res.add(new ArrayList<>(curSet));
            return;
        }
        if(i>n){
            return;
        }

        // Decision to add num at i to current set
        curSet.add(i);
        combinnationCreator(i+1,n,k,curSet,res);
        curSet.remove(curSet.size()-1);

        // Decision to not add num at i to current set
        combinnationCreator(i+1,n,k,curSet,res);
    }
}

