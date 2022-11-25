from typing import List

class Solution:
    def calPoints(self, operations: List[str]) -> int:
        stack = []

        for op in operations:
            if op == "C":
                stack.pop()
            elif op =="D":
                newVal = stack[-1] *2
                stack.append(newVal)
            elif op =="+":
                valOne = stack.pop()
                valTwo= stack.pop()
                newVal = valOne + valTwo
                stack.append(valTwo)
                stack.append(valOne)
                stack.append(newVal)
                
            else:
                stack.append(int(op))
        return sum(stack)