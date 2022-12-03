from TreeNode import TreeNode
from typing import List, Optional

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        result = []

        def inOrder(curr: Optional[TreeNode]):
            if not curr:
                return None
            inOrder(curr.left)
            result.append(curr.val)
            inOrder(curr.right)

        inOrder(root)
        return result[k-1]
