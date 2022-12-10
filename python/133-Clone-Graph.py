class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        nodeMap = {}
        if not node:
            return None
        def dfs(curr: 'Node'):
            if curr in nodeMap:
                return nodeMap[curr]
            clone = Node(curr.val)
            nodeMap[curr]= clone
            for n in curr.neighbors:
                clone.neighbors.append(dfs(n))
            return clone
        return dfs(node)
