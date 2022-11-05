package Trees.Easy;

import Trees.TreeNode;
/*

 */
public class BalancedBinaryTree {
    // Time Complexity: O(logn)
    // Space: O(1)
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return ((Math.abs(calculateHeight(root.right)-calculateHeight(root.left))<=1)
                && isBalanced(root.left) && isBalanced(root.right));

    }

    public int calculateHeight(TreeNode curr){
        if(curr==null){
            return 0;
        }

        int leftTree = calculateHeight(curr.left);
        int rightTree = calculateHeight(curr.right);

        return 1 + Math.max(leftTree,rightTree);
    }
}
