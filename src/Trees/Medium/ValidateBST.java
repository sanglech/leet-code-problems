package Trees.Medium;

import Trees.TreeNode;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return(valid(root,null,null));
    }

    public boolean valid(TreeNode curr, Integer leftBound, Integer rightBound){
        if (curr == null) return true;

        if ((leftBound != null && curr.val <= leftBound)
                || rightBound != null && curr.val >= rightBound) {
            return false;
        }

        return valid(curr.left,leftBound,curr.val) && valid(curr.right,curr.val, rightBound);

    }
}
