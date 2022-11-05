package Stack;

import java.util.*;

/*
    22. Generate Parentheses
 */
public class GenerateParanthesis {
    Stack<String> stack = new Stack<>();

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0) return res;
        backTracking(0,0,n);
        return res;
    }

    public void backTracking(int openCount, int closedCount, int n){
        if(openCount==n && closedCount==n){
            Iterator<String> val = stack.iterator();
            StringBuilder p = new StringBuilder();
            while (val.hasNext()) {
                p.append(val.next());
            }
            res.add(p.toString());
        }
        if(openCount<n){
            stack.push("(");
            backTracking(openCount+1,closedCount,n);
            stack.pop();
        }
        if(closedCount<openCount){
            stack.push(")");
            backTracking(openCount,closedCount+1,n);
            stack.pop();
        }
    }
}
