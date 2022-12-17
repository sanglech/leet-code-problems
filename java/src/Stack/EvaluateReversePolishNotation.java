package Stack;

import java.util.Objects;
import java.util.Stack;

/*
    150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int res =0;
        if(tokens.length==0) return res;
        Stack<String> stack = new Stack<>();

        for(String s : tokens){
            if(Objects.equals(s, "+")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res= num1+num2;
                stack.push(String.valueOf(res));
            }
            else if(Objects.equals(s,"-")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res= num2-num1;
                stack.push(String.valueOf(res));
            }
            else if(Objects.equals(s,"/")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res= num2/num1;
                stack.push(String.valueOf(res));
            }
            else if(Objects.equals(s,"*")){
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                res= num1*num2;
                stack.push(String.valueOf(res));
            }
            else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}