package Trees.Easy;

import Trees.TreeNode;

/*
    112. Path Sum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int val =0;
        return dfs(root,val,targetSum);
    }

    public boolean dfs(TreeNode current, int currentSum, int targetSum){
        if(current ==null) return false;
        currentSum+=current.val;

        if(current.left==null && current.right==null){
            return currentSum == targetSum;
        }

        return (dfs(current.left,currentSum, targetSum) || dfs(current.right,currentSum, targetSum));

    }
}
