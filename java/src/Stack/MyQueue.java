package Stack;

import java.util.Stack;

/*
    232. Implement Queue using Stacks
 */
public class MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> helperStack;
    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int x) {
        while(!mainStack.isEmpty()){
            helperStack.push(mainStack.pop());
        }
        helperStack.push(x);
        while(!helperStack.isEmpty()){
            mainStack.push(helperStack.pop());
        }
    }

    public int pop() {
        if (mainStack.isEmpty()){
            return 0;
        }
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}
