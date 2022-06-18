package Trees;

public class Easy {

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

    // Time Complexity: O(n)
    // Space: O(1)
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q== null) return true;
        if(p==null || q== null || p.val!=q.val) return false;

        return (isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(subRoot==null) return true;
        if(root == null)  return false;

        if(isSameTree(root,subRoot)) return true;

        return (isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot));

    }


    // Time Complexity: O(logn)
    // Space: O(1)
    public boolean isSameTree2(TreeNode s, TreeNode t){
        if(s==null && t==null) return true;

        if(s!=null && t!=null && s.val==t.val){
            return (isSameTree(s.left,t.left) && isSameTree(s.right,t.right));
        }

        return false;
    }

    // Time Complexity: O(logn)
    // Space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return null;

        if(root.val==p.val || root.val==q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left!=null && right!=null) return root;
        else if(left!=null) return left;
        else return right;
    }

}
