from typing import List

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courses = {}
        if numCourses == 0:
            return True
        for c in range(numCourses):
            courses[c] = []

        for preReq,course in prerequisites:
            courses[course].append(preReq)
        
        visit = set()

        def dfs(crs):
            if crs in visit:
                return False
            if crs ==[]:
                return True
            visit.add(crs)
            for pre in courses[crs]:
                if not dfs(pre):
                    return False
            visit.remove(crs)
            courses[crs] = []
            return True
        for c in range(numCourses):
            if not dfs(c):
                return False
        return True
