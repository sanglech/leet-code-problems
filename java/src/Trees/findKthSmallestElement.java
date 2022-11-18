package Trees;

import java.util.ArrayList;
import java.util.List;

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
