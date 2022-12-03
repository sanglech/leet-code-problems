package Trees.Medium;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
    230. Kth Smallest Element in a BST
 */
public class findKthSmallestElement {
    List<Integer> sortedArr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorderTraverse(root);
        return sortedArr.get(k-1);
    }

    void inorderTraverse(TreeNode root) {
        if (root == null) return;
        inorderTraverse(root.left);
        sortedArr.add(root.val);
        inorderTraverse(root.right);
    }
}
