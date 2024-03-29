package SlidingWindow;

/*
    121. Best Time to Buy and Sell Stock
    Time Complexity: O(n)
    Space: O(1)

 */
public class MaxProfit {
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
}
