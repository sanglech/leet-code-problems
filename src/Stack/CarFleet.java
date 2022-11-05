package Stack;

import java.util.ArrayList;
import java.util.List;

/*
    853. Car Fleet
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0 || speed.length==0) return 0;
        int res =0;
        double currTime =0;
        List<List<Integer>> positionSpeed = new ArrayList<>();
        for(int i =0; i< position.length;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(position[i]);
            temp.add(speed[i]);
            positionSpeed.add(temp);
        }

        positionSpeed.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));

        for(int i =positionSpeed.size()-1;i>=0;i--){
            List<Integer> coord = positionSpeed.get(i);
            double destTime = (double)(target-coord.get(0))/ coord.get(1);
            if(currTime < destTime){
                res++;
                currTime= destTime;
            }
        }
        return res;
    }
}
