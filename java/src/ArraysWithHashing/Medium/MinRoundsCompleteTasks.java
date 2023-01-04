package ArraysWithHashing.Medium;

import java.util.HashMap;

/*
    2244. Minimum Rounds to Complete All Tasks
 */
public class MinRoundsCompleteTasks {
    public static int minimumRounds(int[] tasks) {
        if(tasks.length<=1) return -1;
        int res =0;

        HashMap<Integer,Integer> counts = new HashMap<>();

        for (int t: tasks){
            counts.merge(t,1,Integer::sum);
        }

        for (Integer key: counts.keySet()){
            int temp = counts.get(key);
            while(temp>0){
                res++;
                if(temp==1) return -1;
                if(temp%2==0 && temp%3!=0){
                    temp-=2;
                }
                else {
                    temp-=3;
                }
            }
        }
        return res;
    }
}
