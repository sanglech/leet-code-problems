package Trees;

/*
    1448. Count Good Nodes in Binary Tree (Preorder Traversal)
 */
public class CountGoodNodes {
    public int goodNodes(TreeNode root) {
        if (root==null) return 0;
        return countGoodNodes(root, root.val);
    }

    public int countGoodNodes(TreeNode curr, int maxVal){
        int res =0;
        if(curr==null) return 0;
        if(curr.val>= maxVal) res++;
        maxVal= Math.max(maxVal,curr.val);
        res +=countGoodNodes(curr.left,maxVal);
        res += countGoodNodes(curr.right,maxVal);
        return res;
    }
}
