from typing import List

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answer = [0] * len(temperatures)
        if len(temperatures)<=1:
            return answer
        days = []

        for currentDay in range(len(temperatures)):
            while days and temperatures[days[-1]] < temperatures[currentDay]:
                prevDay = days.pop()
                answer[prevDay]=currentDay-prevDay
            days.append(currentDay)
        return answer
 
# How to call class and use function for VSCode (debugger)
sol = Solution()
sol.dailyTemperatures([73,74,75,71,69,72,76,73])