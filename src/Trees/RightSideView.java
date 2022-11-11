package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    199. Binary Tree Right Side View (Basic BFS)
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root ==null) return res;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            for( int i =0; i< level;i++){
                TreeNode curr = q.poll();
                if(i==0) res.add(curr.val);
                if(curr.right!=null) q.offer(curr.right);
                if(curr.left!=null) q.offer(curr.left);
            }

        }

        return res;
    }
}
