package SlidingWindow;

import java.util.Arrays;

/*
    1833. Maximum Ice Cream Bars
 */
public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        if (costs.length==0 || coins ==0) return 0;
        int res =0;
        Arrays.sort(costs);

        for (int iceCream : costs) {
            if (coins - iceCream >= 0) {
                res++;
                coins -= iceCream;
            } else {
                break;
            }
        }
        return res;
    }
}
