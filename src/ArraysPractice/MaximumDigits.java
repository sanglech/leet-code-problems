package ArraysPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
Given an array of integers determine the maximum digits and return a list of all the digits which appear the most.
Ex. [ 1, 2, 3, 22, 13, 35 ].
The maximum number of digits is 2 and 3 [1->2, 2->3, 3->3, 5->1].
 */
public class MaximumDigits {
    public static Integer[] maximumDigits(int[] arr){
        List<Integer> res = new ArrayList<>();

        //Initialize map (digits 0-9)
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<10;i++){
            map.put(i,0);
        }
        int max = 0;

        for(int num: arr){
            String s = String.valueOf(num);
            for(int j=0; j<s.length();j++){
                map.put(Integer.valueOf(s.substring(j,j+1)),map.get(Integer.parseInt(s.substring(j,j+1)))+1);
            }
        }

        max = Collections.max(map.values());

        for(Integer key: map.keySet()){
            if(map.get(key)==max){
                res.add(key);
            }
        }

        return res.toArray(Integer[]::new);
    }
}
