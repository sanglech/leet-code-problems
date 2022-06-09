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

                if(!Objects.equals(brackets.get(stack2.peek()),
                        String.valueOf(s.charAt(i)))){
                    return false;
                }

                else {
                    stack2.pop();
                }
            }
        }

        if(stack2.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
