package Greedy;

import java.util.Arrays;

/*
    452. Minimum Number of Arrows to Burst Balloons
 */
public class MinNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        if(points.length <=1) return points.length;
        // Sort the balloons by the end position of the arrow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));

        int result = 1;
        int previous = 0;

        for(int current = 1; current < points.length; current++){
            if(points[current][0] > points[previous][1]){
                result++;
                previous = current;
            }
        }
        return result;
    }
}
