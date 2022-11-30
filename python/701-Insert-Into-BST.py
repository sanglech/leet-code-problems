from typing import Optional
from TreeNode import TreeNode

class Solution:
    def insertIntoBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        newNode = TreeNode(val)
        if not root:
            return newNode
        currNode = root
        prevNode = None

        while currNode:
            prevNode = currNode
            if currNode.val < val:
                currNode = currNode.right
            else:
                currNode = currNode.left
        if prevNode.val < val:
            prevNode.right = newNode
        else:
            prevNode.left = newNode

        return root
