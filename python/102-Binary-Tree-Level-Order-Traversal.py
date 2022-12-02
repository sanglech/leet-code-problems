from collections import deque
from TreeNode import TreeNode
from typing import List, Optional

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return res
        q= deque()

        q.append(root)

        while q:
            level = []
            for i in range(len(q)):
                curr = q.popleft()
                level.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
            res.append(level)
        return res