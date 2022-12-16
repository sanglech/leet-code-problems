class MyQueue:

    def __init__(self):
        self.myQ = []

    def push(self, x: int) -> None:
        self.myQ.append(x)

    def pop(self) -> int:
        return self.myQ.pop(0)

    def peek(self) -> int:
        return self.myQ[0]

    def empty(self) -> bool:
        return len(self.myQ)==0

