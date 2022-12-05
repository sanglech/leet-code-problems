from typing import Optional
from TreeNode import TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        if not root:
            return None
        if root.val == val:
            return root
        elif root.val < val:
            return self.searchBST(root.right,val)
        else:
            return self.searchBST(root.left,val)