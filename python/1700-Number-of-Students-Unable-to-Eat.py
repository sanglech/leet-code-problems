# class Solution:
#     def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
#         while students and sandwiches and sandwiches[0] in students:
#             if students[0]==sandwiches[0]:
#                 students.pop(0)
#                 sandwiches.pop(0)
#             else:
#                 k = students.pop(0)
#                 students.append(k)            
#         return len(students)

#my solution not working need to debug
from typing import List
from collections import deque

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        q= deque()

        for s in students:
            q.append(s)
        
        while q and sandwiches[-1] in q:
            student = q.popleft()
            if(student == sandwiches[-1]):
                sandwiches.pop()
            else:
                q.append(student)
        return len(q)