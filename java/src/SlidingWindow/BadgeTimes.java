package SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Problem:
Write a function that finds anyone who badged into the room three or more times in a one-hour period.
Your function should return each of the employees who fit that criteria,
plus the times that they badged in during the one-hour period.
If there are multiple one-hour periods where this was true for an employee,
just return the earliest one for that employee.
 */

// Time Complexity: O(nlogn) due to sorting algo
// Space: O(n)
public class BadgeTimes {

    public static void badgeTimes(String[][] badgeTimes){
        HashMap<String, List<Integer>> map = new HashMap<>();
        HashMap<String, List<Integer>> resultMap = new HashMap<>();
        for (String[] badgeTime : badgeTimes) {

            if (map.containsKey(badgeTime[0])) {
                int time = Integer.parseInt(badgeTime[1]);
                map.get(badgeTime[0]).add(time);
            } else {
                List<Integer> times = new ArrayList<>();
                times.add(Integer.parseInt(badgeTime[1]));
                map.putIfAbsent(badgeTime[0], times);
            }
        }

        for(List<Integer> times: map.values()){
            Collections.sort(times);
        }

        for (String person: map.keySet()){
            List<Integer> times = map.get(person);
            int start =0;
            int end =1;
            int window = 1;

            while(end<times.size()){
                if(times.get(end) - times.get(start) <=100){
                    window++;
                }

                if(times.get(end) - times.get(start) >100 && window <3){
                    start++;
                    window =1;
                    end = start +1;
                }

                else if(times.get(end) - times.get(start) >100 && window >=3){
                    break;
                }
                end++;
            }

            if (window>=3){
                List<Integer> badgedTimes = new ArrayList<>();

                for(int i=start;i<=start+window;i++){
                    badgedTimes.add(times.get(i));
                }
                resultMap.put(person,badgedTimes);
            }
        }
        System.out.println("result: "+ resultMap);
    }
}
