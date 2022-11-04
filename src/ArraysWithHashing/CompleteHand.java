package ArraysWithHashing;

import java.util.HashMap;

public class CompleteHand {
    public static boolean completeHand(String hand){
        HashMap<Integer,Integer> tileMap = new HashMap<>();
        boolean singleDouble = false;
        // 1) populate map with tile and their counts
        for(int i =0;i<hand.length();i++){
            int tile = Integer.parseInt(hand.substring(i,i+1));
            if(!tileMap.containsKey(tile)){
                tileMap.put(tile,1);
            } else {
                tileMap.put(tile, tileMap.get(tile)+1);
            }
        }
        //System.out.println("tileMap check: "+ Arrays.asList(tileMap));
        for(Integer key: tileMap.keySet()){

            int value = tileMap.get(key);
            while(value>0){
                if(value==1 || value <0){
                    return false;
                }
                else if(value == 2){
                    if(!singleDouble){
                        singleDouble = true;
                        value = value-2;
                    }
                    else {
                        return false;
                    }
                }
                else{
                    value = value -3;
                }
            }
        }

        if(!singleDouble){
            return false;
        }

        return true;
    }
}
