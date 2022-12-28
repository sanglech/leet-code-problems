package Greedy;

import java.util.Collections;
import java.util.PriorityQueue;

/*
    1962. Remove Stones to Minimize the Total
 */
public class RemoveStonesMinimizeTotal {
    public static int minStoneSum(int[] piles, int k) {
        int res = 0;

        if(piles.length==0) return res;
        PriorityQueue<Integer> prq = new PriorityQueue<>(Collections.reverseOrder());

        for (int p: piles){
            prq.offer(p);
        }

        while(k>0 && !prq.isEmpty()){
            int currMax =prq.poll();
            currMax -= Math.floorDiv(currMax,2);
            prq.offer(currMax);
            k--;
        }

        while(!prq.isEmpty()){
            res+= prq.poll();
        }

        return res;
    }
}
