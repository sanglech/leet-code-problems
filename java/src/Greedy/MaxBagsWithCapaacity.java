package Greedy;

import java.util.Arrays;

/*
    2279. Maximum Bags With Full Capacity of Rocks
 */
public class MaxBagsWithCapaacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int [capacity.length];
        int res =0;
        for (int i =0;i<diff.length;i++){
            diff[i] = capacity[i]- rocks[i];
        }
        Arrays.sort(diff);

        for( int i =0;i < diff.length && additionalRocks>0;i++){
            if(additionalRocks>=diff[i]){
                res++;
            }
            additionalRocks-=diff[i];
        }

        return res;
    }
}
