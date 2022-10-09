package Trees;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode newNode = new TreeNode(val);

        if(root==null) return newNode;

        while(current!=null){
            prev= current;
            if(current.val<val){
                current = current.right;
            }
            else {
                current = current.left;
            }
        }
        if(prev.val > val){
            prev.left = newNode;
        }
        else {
            prev.right = newNode;
        }
        return root;
    }
}
