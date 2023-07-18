class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buy = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            if(buy > prices[i])
                buy = prices[i];
            
            if(prices[i] - buy > maxProfit)
                maxProfit = prices[i] - buy;
        }
        return maxProfit;
    }
}