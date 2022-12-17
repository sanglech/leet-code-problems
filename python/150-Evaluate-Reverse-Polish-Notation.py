from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        if len(tokens) == 0:
            return 0
        stack = []

        for op in tokens:
            if op == "+":
                res=stack.pop() + stack.pop()
            elif op == "-":
                a,b = stack.pop(), stack.pop()
                res= b-a
            elif op == "*":
                res =stack.pop() * stack.pop()
            elif op == "/":
                a,b = stack.pop(), stack.pop()
                res = int(b/a)
            else:
                res = int(op)
            stack.append(res)
        return stack.pop()
