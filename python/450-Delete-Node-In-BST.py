# Definition for a binary tree node.
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def findMin(curr):
            while curr and curr.left:
                curr = curr.left
            return curr
        
        if not root:
            return None
        if key > root.val:
            root.right = self.deleteNode(root.right, key)
        elif key < root.val:
            root.left = self.deleteNode(root.left, key)
        else:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                minNode = findMin(root.right)
                root.val = minNode.val
                root.right = self.deleteNode(root.right, minNode.val)
                return root
        return root

# My solution not working
""" class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        if root == None:
            return None

        def findMin(curr):
            while curr and curr.left:
                curr = curr.left
            return curr

        def findNode(curr):
            if not curr:
                return None
            elif curr.val > key:
                return findNode(curr.left)
            elif curr.val < key:
                return findNode(curr.right)
            else:
                if not curr.left:
                    return curr.right
                elif not curr.right:
                    return curr.left
                else:
                    minNode = findMin(curr.right)
                    curr.val = minNode.val
                    curr.right = self.deleteNode(curr.right,minNode.val)
        findNode(root)
        return root """
 
 