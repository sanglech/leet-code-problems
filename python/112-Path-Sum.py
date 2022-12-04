from collections import deque
from TreeNode import TreeNode
from typing import Optional

class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        
        def dfs(current: Optional[TreeNode],currentResult: int):
            if not current:
                return False
            currentResult= currentResult + current.val

            if not current.left and not current.right:
                return currentResult == targetSum
            
            return dfs(current.left,currentResult) or dfs(current.right,currentResult)
        
        return dfs(root,0)
