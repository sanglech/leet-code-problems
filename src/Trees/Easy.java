package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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


    /*

*/

    public List<Integer> preorder(PreOrderNode root) {
        List <Integer> output = new ArrayList<Integer>();
        dfs(root,output);

        return output;
    }

    public void dfs(PreOrderNode curr, List<Integer> out){
        if(curr==null) return;
        else {
            out.add(curr.val);
            for(PreOrderNode c: curr.children){
                dfs(c,out);
            }
        }
    }

    // BFS algorithim
    // Time complexity: O(N)
    // Space complexity O(N)
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> pq = new PriorityQueue<>();
        ArrayList<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;
        pq.add(root);

        while (!pq.isEmpty()) {
            int len = pq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = pq.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    pq.add(curr.left);
                }
                if (curr.right != null) {
                    pq.add(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }

}
