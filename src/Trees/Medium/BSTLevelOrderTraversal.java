package Trees.Medium;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
/*
    102. Binary Tree Level Order Traversal
     BFS algorithim
     Time complexity: O(N)
     Space complexity O(N)
 */
public class BSTLevelOrderTraversal {

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
