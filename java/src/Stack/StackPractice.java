package Stack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class StackPractice {

    // Time Complexity: O(n)
    // Space: O(n)
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

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        int temp;
        int res = 0;
        for (String operation : operations) {
            if (Character.isDigit(operation.charAt(0)) || operation.charAt(0)=='-') {
                stack.push(Integer.parseInt(operation));
            }

            else if(operation.equals("D")){
                temp = stack.peek();
                temp = temp *2;
                stack.push(temp);
            }
            else if(operation.equals("C")){
                stack.pop();
            }

            else if(operation.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                temp = temp1+temp2;
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp);
            }
        }

        while(!stack.isEmpty()){
            res+= stack.pop();
        }

        return res;
    }

}

// Time Complexity: O(1)
// Space: O(n)
// Trick: have 2 stacks 1 for values and one for keeping track of minimum value.
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