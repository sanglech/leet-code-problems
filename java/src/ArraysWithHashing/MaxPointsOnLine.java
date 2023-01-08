package ArraysWithHashing;

import java.util.HashMap;
import java.util.Map;

/*
    149. Max Points on a Line
 */
public class MaxPointsOnLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n; // 2 or less points can always form a line.
        int ans = 2;

        for(int[] a : points){
            //Map<Double, Integer> for storing (slope, no of times 2 points generate this slope.)
            Map<Double, Integer> map = new HashMap<>();
            for(int[] b : points){
                if(a == b) continue; // dont measure slope for same points in plane.
                // if a is (x1, y1) and b is(x2, y2) then slope is (y2 - y1)/(x2 -x1)
                // a (a0, a1) & b is (b0, b1)
                double slope = 0;
                if(b[0] - a[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] -a[1]) / (double)(b[0] - a[0]);
                //map.getOrDefault(slope, 0)+1 is adding 1 more point count for that slope if we already had that slope.
                // by default , 1 will be count of a new slope.
                map.put(slope, map.getOrDefault(slope, 1)+1);
                ans = Math.max(ans, map.get(slope));
            }
        }
        //ans itself represnets max no of points forms a line
        return ans;
    }
}
