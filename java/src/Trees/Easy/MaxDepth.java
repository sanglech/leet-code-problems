package Trees.Easy;

import Trees.TreeNode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int h = 1 + Math.max(this.maxDepth(root.left),this.maxDepth(root.right));

        return h;
    }
}
