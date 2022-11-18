package Trees.Easy;

import Trees.TreeNode;

/*
    104. Maximum Depth of Binary Tree
 */
public class MaxHeight {
    // Time Complexity: O(logn)
    // Space: O(1)
    int maxHeight =0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxHeight;
    }

    private int maxDepth(TreeNode curr){
        if (curr==null) return 0;

        int left= maxDepth(curr.left);
        int right=  maxDepth(curr.right);

        maxHeight = Math.max(left+right, maxHeight);

        return Math.max(left,right) +1;

    }
}
