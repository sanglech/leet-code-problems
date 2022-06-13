package Stack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class StackPractice {
    public boolean isValid(String s) {

        // Write your code here
        HashMap<String, String> brackets = new HashMap<>();
        brackets.put("(", ")");
        brackets.put("{", "}");
        brackets.put("[", "]");

        if(s.length()%2!=0){
            return false;
        }
        Stack<String> stack2 = new Stack<String>();
        for (int i=0; i < s.length();i++){
            if(brackets.containsKey(String.valueOf(s.charAt(i)))){
                stack2.push(String.valueOf(s.charAt(i)));
            }
            else {
                if(stack2.isEmpty()){
                    return false;
                }

                if(!Objects.equals(brackets.get(stack2.peek()), String.valueOf(s.charAt(i)))){
                    return false;
                }
                else {
                    stack2.pop();
                }
            }
        }

        return stack2.isEmpty();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }
        public void push(int val) {
            stack.push(val);
            if(minStack.isEmpty()){
                minStack.push(val);
            }
            else {
                minStack.push(Math.min(val,minStack.peek()));
            }
        }
        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
