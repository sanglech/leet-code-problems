package ArraysWithHashing.Easy;

import java.util.ArrayList;

public class GetConcatination {
    public static int[] getConcatenation(int[] nums) {
        ArrayList<Integer> ansList = new ArrayList<>();
        for (int i=0;i< nums.length *2;i++){
            if(i>nums.length-1){
                ansList.add(i,nums[i-nums.length]);
            }
            else {
                ansList.add(i,nums[i]);
            }
        }
        return ansList.stream().mapToInt(k->k).toArray();
    }
}
