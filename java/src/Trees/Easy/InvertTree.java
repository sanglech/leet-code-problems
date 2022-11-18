package Trees.Easy;

import Trees.TreeNode;

/*
    226. Invert Binary Tree
 */
public class InvertTree {
    // Time Complexity: O(n)
    // Space: O(1)
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        this.invertTree(root.left);
        this.invertTree(root.right);
        return root;
    }
}
