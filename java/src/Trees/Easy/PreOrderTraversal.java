package Trees.Easy;

import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;

        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                res.add(curr.val);
                if(curr.right!=null){
                    stack.push(curr.right);
                }
                curr = curr.left;
            }
            else {
                curr= stack.pop();
            }
        }
        return res;
    }
}
