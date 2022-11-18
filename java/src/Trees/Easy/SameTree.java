package Trees.Easy;

import Trees.TreeNode;

/*
    100. Same Tree
    572. Subtree of Another Tree

 */
public class SameTree {
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
}
