package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuePractice {
    public static int countStudents(int[] students, int[] sandwiches) {

        int count =0;
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for(int student: students){
            q.add(student);
        }

        for(int i = sandwiches.length-1; i>=0;i--){
            stack.add(sandwiches[i]);
        }
        int sand = stack.pop();
        while(!q.isEmpty() && count<students.length){
            int student = q.poll();
            if(sand==student){
                if(!stack.isEmpty()){
                    sand = stack.pop();
                }
                count=0;
            }
            else {
                q.add(student);
                count++;
            }
            if(count>students.length){
                q.add(student);
            }
        }
        return q.size();
    }
}
