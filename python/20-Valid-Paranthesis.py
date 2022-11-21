class Solution:
    def isValid(self, s: str) -> bool:
        paraDict= {')': '(', '}':'{', ']':'['}
        stack = []
        if len(s)%2!=0:
            return False
        for c in s:
            if c not in paraDict:
                stack.append(c)
                continue
            else:
                # No peek function use stack[-1] as peek
                if not stack or paraDict[c]!=stack[-1]:
                    return False
            stack.pop()
        return not stack
