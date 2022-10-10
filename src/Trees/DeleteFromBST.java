package Trees;

public class DeleteFromBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key) ;
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    public TreeNode findMin(TreeNode current){
        while(current!=null && current.left!=null){
            current= current.left;
        }
        return current;
    }
}
