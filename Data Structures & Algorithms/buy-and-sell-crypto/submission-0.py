class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        last_bought = prices[0]
        max_profit = 0
        for i in range(1, n):
            profit = prices[i] - last_bought
            max_profit = max(profit, max_profit)
            if(profit < 0):
                last_bought = prices[i]
        return max_profit
        