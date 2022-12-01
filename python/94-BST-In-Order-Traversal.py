from TreeNode import TreeNode
from typing import List, Optional

class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if not root:
            return result
        
        def inOrder(curr:Optional[TreeNode]):
            if not curr:
                return None
            inOrder(curr.left)
            result.append(curr.val)
            inOrder(curr.right)
        
        inOrder(root)
        return result
