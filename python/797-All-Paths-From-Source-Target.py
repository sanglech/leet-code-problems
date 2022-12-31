from typing import List

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        if not graph:
            return []
        adjList = {}
        for i in range(len(graph)):
            adjList[i] = graph[i] 
        N = len(graph)
        arr = [(0, [0])]
        output = []
        while arr:
            node, path = arr.pop()
            if node == N - 1:
                output.append(path)
            for nei in adjList[node]:
                arr.append((nei, path+[nei]))
        return output
