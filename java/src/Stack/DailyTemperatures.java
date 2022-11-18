package Stack;

import java.util.Stack;
/*
    739. Daily Temperatures
    Time: O(n)
    Mem: O(n)
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length<=1) return new int []{0};

        int[] answer = new int[temperatures.length];
        Stack<Integer> days = new Stack<>();

        for(int currDay = 0;currDay<temperatures.length; currDay++){
            while(!days.isEmpty() && temperatures[days.peek()] < temperatures[currDay]){
                int prevDay = days.pop();
                answer[prevDay] = currDay- prevDay;
            }
            days.add(currDay);
        }

        return answer;
    }
}
