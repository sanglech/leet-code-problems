package SlidingWindow;

import java.util.HashSet;

public class SlidingWindow {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }

        int buyDay= 0;
        int maxProfit = Math.max(0,prices[1]-prices[buyDay]);

        for (int sellDay =1; sellDay< prices.length; sellDay++) {
            int currPrice = prices[sellDay];
            if(currPrice-prices[buyDay]<0){
                buyDay=sellDay;
            } else {
                maxProfit = Math.max(maxProfit,currPrice-prices[buyDay]);
            }
        }

        return maxProfit;
    }


    public static int lengthOfLongestSubstring(String s) {
        int max =0;
        int l =0;
        HashSet<Character> visited = new HashSet<>();

        if(s.length()==0){
            return 0;
        }
        for(int r=0;r<s.length();r++){
            while(visited.contains(s.charAt(r))){
                visited.remove(s.charAt(l));
                l++;
            }
            max = Math.max(r-l+1, max);
            visited.add(s.charAt(r));
        }

        return max;
    }
}
