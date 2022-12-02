from TreeNode import TreeNode
from typing import List, Optional
from collections import deque

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result =[]
        if not root:
            return result
        q = deque()
        q.append(root)

        while q:
            for i in range(len(q)):
                curr = q.popleft()
                if i ==0:
                    result.append(curr.val)
                if curr.right:
                    q.append(curr.right)
                if curr.left:
                    q.append(curr.left)
        return result
