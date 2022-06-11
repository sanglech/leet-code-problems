package Trees;

public class Easy {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
  }
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
