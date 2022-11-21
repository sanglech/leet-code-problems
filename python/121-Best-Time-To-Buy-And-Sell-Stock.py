from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
         if len(prices) == 1:
             return 0
         l=0
         maxProfit = 0

         for r, price in enumerate(prices):
            currProfit = price - prices[l]
            maxProfit = max(maxProfit,currProfit)
            if (currProfit < 0):
                l=r 
         return maxProfit