package Trees;

import java.util.List;

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

// Definition for a Node.
class PreOrderNode {
    public int val;
    public List<PreOrderNode> children;

    public void PreOrderNode() {}

    public void PreOrderNode(int _val) {
        val = _val;
    }

    public void PreOrderNode(int _val, List<PreOrderNode> _children) {
        val = _val;
        children = _children;
    }
};