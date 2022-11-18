package ArraysWithHashing.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    219. Contains Duplicate II
 */
public class ContainsNearbyDuplicates {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i =0; i< nums.length;i++){
            List<Integer> temp;
            if(!map.containsKey(nums[i])){
                temp = new ArrayList<>();
            }
            else {
                temp = map.get(nums[i]);
                for(Integer j: temp){
                    if(Math.abs(i-j) <=k){
                        return true;
                    }
                }
            }
            temp.add(i);
            map.put(nums[i],temp);
        }

        return false;
    }
}
